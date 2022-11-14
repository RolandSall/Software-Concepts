package com.rolandsall.customer.services;

import com.rolandsall.client.fraud.FraudClient;
import com.rolandsall.client.fraud.FraudResponse;
import com.rolandsall.client.notification.NotificationClient;
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
    private FraudClient fraudClient;
    @Mock
    private NotificationClient notificationClient;
    private ICustomerService ICustomerService;

    @BeforeEach
    void setUp() {
        ICustomerService = new CustomerService(iCustomerRepository, fraudClient,notificationClient);
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
    void Register_calls_dao_save_with_correct_parameters() {
        // arrange
        Customer customer = Customer.builder()
                .firstName("Roland")
                .lastName("Salloum")
                .email("roland.salloum00@outlook.com")
                .id(UUID.randomUUID())
                .build();


        when(fraudClient.CheckIfFraud(any()))
                .thenReturn(new ResponseEntity<>(new FraudResponse(false), HttpStatus.OK));


        when(notificationClient.sendNotification(any())).thenReturn(new ResponseEntity<>(HttpStatus.OK));


        // action
        ICustomerService.Register(customer);


        // assert
        ArgumentCaptor<Customer> studentArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(iCustomerRepository).save(studentArgumentCaptor.capture());
        Customer captorValue = studentArgumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(customer);

    }

    @Test
    void Register_throws_IllegalStateException_when_fraud_response() {
        // arrange
        Customer customer = Customer.builder()
                .firstName("Roland")
                .lastName("Salloum")
                .email("roland.salloum00@outlook.com")
                .id(UUID.randomUUID())
                .build();


        when(fraudClient.CheckIfFraud(any()))
                .thenReturn(new ResponseEntity<>(new FraudResponse(true), HttpStatus.OK));

        // assert & action
        assertThatThrownBy(() -> ICustomerService.Register(customer))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("fraudster");

        verify(iCustomerRepository, never()).save(any());

    }

    @Test
    void Register_throws_RuntimeException_when_email_is_not_sent() {
        // arrange
        Customer customer = Customer.builder()
                .firstName("Roland")
                .lastName("Salloum")
                .email("roland.salloum00@outlook.com")
                .id(UUID.randomUUID())
                .build();


        when(fraudClient.CheckIfFraud(any()))
                .thenReturn(new ResponseEntity<>(new FraudResponse(false), HttpStatus.OK));


        when(notificationClient.sendNotification(any())).thenReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

        // assert & action
        assertThatThrownBy(() -> ICustomerService.Register(customer))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Email was not sent");

        verify(iCustomerRepository).save(any());

    }
}