package com.rolandsall.customer.helper;

import com.rolandsall.amqp.RabbitMQMessageProducer;
import com.rolandsall.client.notification.NotificationRequest;
import com.rolandsall.customer.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificationHandlerTest {

    private NotificationHandler notificationHandler;

    @Mock
    private RabbitMQMessageProducer rabbitMQMessageProducer;

    @BeforeEach
    void setUp() {
        notificationHandler = new NotificationHandler(rabbitMQMessageProducer);
    }

    @Test
    void notificationHandler_calls_rabbitMqMessageProduct_publish_with_correct_parameter() {
        //arrange
        UUID id = UUID.randomUUID();
        Customer customer = Customer.builder()
                .firstName("Roland")
                .lastName("Salloum")
                .email("roland.salloum00@outlook.com")
                .id(id)
                .build();



        //action
        notificationHandler.publish(customer);
        NotificationRequest notification = getExpectedNotification(customer);

        //assert
        verify(rabbitMQMessageProducer).publish(notification,"internal.exchange","internal.notification.routing-key");

    }

    private NotificationRequest getExpectedNotification(Customer customer) {
        return new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to this channel...", customer.getFirstName()));
    }
}