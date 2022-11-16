package com.rolandsall.customer.helper;

import com.rolandsall.amqp.RabbitMQMessageProducer;
import com.rolandsall.client.notification.NotificationRequest;
import com.rolandsall.customer.models.Customer;
import com.rolandsall.customer.services.INotificationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationHandler implements INotificationHandler {



    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    @Autowired
    public NotificationHandler(RabbitMQMessageProducer rabbitMQMessageProducer) {
        this.rabbitMQMessageProducer = rabbitMQMessageProducer;
    }

    @Override
    public void publish(Customer customer) {
        NotificationRequest request = buildNotification(customer);
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
