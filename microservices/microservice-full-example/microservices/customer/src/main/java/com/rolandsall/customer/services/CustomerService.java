package com.rolandsall.customer.services;

import com.rolandsall.amqp.RabbitMQMessageProducer;
import com.rolandsall.client.fraud.FraudClient;
import com.rolandsall.client.fraud.FraudResponse;
import com.rolandsall.client.notification.NotificationClient;
import com.rolandsall.client.notification.NotificationRequest;
import com.rolandsall.customer.models.Customer;
import com.rolandsall.customer.respositories.customer.ICustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository iCustomerRepository;

    private final FraudClient fraudClient;
    //private final NotificationClient notificationClient;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    @Autowired
    public CustomerService(ICustomerRepository iCustomerRepository, FraudClient fraudClient, RabbitMQMessageProducer rabbitMQMessageProducer) {
        this.iCustomerRepository = iCustomerRepository;
        this.fraudClient = fraudClient;
        this.rabbitMQMessageProducer = rabbitMQMessageProducer;
    }


    @Override
    public List<Customer> GetUsers() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void Register(Customer customer) {
        customer.setId(UUID.randomUUID());
        checkIfFraud(customer);
        iCustomerRepository.save(customer);
        sendNotification(customer);

    }

    private void checkIfFraud(Customer customer) {
        FraudResponse response = fraudClient.CheckIfFraud(customer.getId()).getBody();

        if (Objects.requireNonNull(response).isFraud()) {
            throw new IllegalStateException("fraudster");
        }
    }

    private void sendNotification(Customer customer) {
        NotificationRequest request = buildNotification(customer);
//        ResponseEntity notificationResponse = notificationClient.sendNotification(request);
//
//        if (Objects.requireNonNull(notificationResponse).getStatusCode().is5xxServerError()) {
//            throw new RuntimeException("Email was not sent");
//        }
        rabbitMQMessageProducer.publish(
                request,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }

    private static NotificationRequest buildNotification(Customer customer) {
        return new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to this channel...", customer.getFirstName()));
    }

}
