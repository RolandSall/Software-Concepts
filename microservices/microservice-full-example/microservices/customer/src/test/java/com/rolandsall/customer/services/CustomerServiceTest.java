package com.rolandsall.customer.services;

import com.rolandsall.amqp.RabbitMQMessageProducer;
import com.rolandsall.client.fraud.FraudClient;
import com.rolandsall.client.fraud.FraudResponse;
import com.rolandsall.client.notification.NotificationClient;
import com.rolandsall.client.notification.NotificationRequest;
import com.rolandsall.customer.models.Customer;
import com.rolandsall.customer.respositories.customer.ICustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private ICustomerRepository iCustomerRepository;

    @Mock
    private IFraudHandler fraudHandler;
    @Mock
    private INotificationHandler notificationHandler;
    private ICustomerService ICustomerService;

    @BeforeEach
    void setUp() {
        ICustomerService = new CustomerService(iCustomerRepository, fraudHandler, notificationHandler);
    }

    @Test
    void get_all_customers() {
        //arrange

        //action
        ICustomerService.GetUsers();

        //assert
        verify(iCustomerRepository).findAll();
    }

    @Test
    void Register_calls_dao_save_with_correct_parameters_when_fraud_is_false() {
        // arrange
        Customer customer = Customer.builder()
                .firstName("Roland")
                .lastName("Salloum")
                .email("roland.salloum00@outlook.com")
                .build();


        when(fraudHandler.checkIfFraud(customer)).thenReturn(false);

        // action
        ICustomerService.Register(customer);


        // assert
        ArgumentCaptor<Customer> studentArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(iCustomerRepository).save(studentArgumentCaptor.capture());
        Customer captorValue = studentArgumentCaptor.getValue();
        assertThat(captorValue).isEqualTo(customer);

        verify(notificationHandler).publish(customer);

    }

    @Test
    void do_nothing_when_fraud_is_true() {
        // arrange
        Customer customer = Customer.builder()
                .firstName("Roland")
                .lastName("Salloum")
                .email("roland.salloum00@outlook.com")
                .build();


        when(fraudHandler.checkIfFraud(customer)).thenReturn(true);

        // action
        ICustomerService.Register(customer);


        // assert
        verify(iCustomerRepository, never()).save(customer);
        verify(notificationHandler, never()).publish(customer);

    }


}