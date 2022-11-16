package com.rolandsall.customer.services;

import com.rolandsall.client.fraud.FraudClient;
import com.rolandsall.client.fraud.FraudResponse;
import com.rolandsall.customer.models.Customer;
import com.rolandsall.customer.respositories.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository iCustomerRepository;

    private final IFraudHandler fraudHandler;
    //private final NotificationClient notificationClient;

    private final INotificationHandler notificationHandler;

    @Autowired
    public CustomerService(ICustomerRepository iCustomerRepository, IFraudHandler fraudHandler, INotificationHandler notificationHandler) {
        this.iCustomerRepository = iCustomerRepository;
        this.fraudHandler = fraudHandler;
        this.notificationHandler = notificationHandler;
    }


    @Override
    public List<Customer> GetUsers() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void Register(Customer customer) {
        customer.setId(UUID.randomUUID());
        if (!fraudHandler.checkIfFraud(customer)) {
            iCustomerRepository.save(customer);
            notificationHandler.publish(customer);
        }
    }
}
