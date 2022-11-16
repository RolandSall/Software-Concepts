package com.rolandsall.customer.helper;

import com.rolandsall.client.fraud.FraudClient;
import com.rolandsall.client.fraud.FraudResponse;
import com.rolandsall.customer.models.Customer;
import com.rolandsall.customer.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FraudHandlerTest {

    @Mock
    private FraudClient fraudClient;

    private FraudHandler fraudHandler;

    @BeforeEach
    void setUp() {
        fraudHandler = new FraudHandler(fraudClient);
    }

    @Test
    void checkIfFraud_return_true_when_fraud_response_is_true() {
        // arrange
        Customer customer = Customer.builder()
                .firstName("Roland")
                .lastName("Salloum")
                .email("roland.salloum00@outlook.com")
                .id(UUID.randomUUID())
                .build();


        when(fraudClient.CheckIfFraud(any()))
                .thenReturn(new ResponseEntity<>(new FraudResponse(true), HttpStatus.OK));


        // action
        boolean isAFraud = fraudHandler.checkIfFraud(customer);

        // assert
        assertTrue(isAFraud);

    }

    @Test
    void checkIfFraud_return_false_when_fraud_response_is_false() {
        // arrange
        Customer customer = Customer.builder()
                .firstName("Roland")
                .lastName("Salloum")
                .email("roland.salloum00@outlook.com")
                .id(UUID.randomUUID())
                .build();


        when(fraudClient.CheckIfFraud(any()))
                .thenReturn(new ResponseEntity<>(new FraudResponse(false), HttpStatus.OK));


        // action
        boolean isNotAFraud = fraudHandler.checkIfFraud(customer);

        // assert
        assertFalse(isNotAFraud);

    }

    @Test
    void checkIfFraud_throws_NullPointerException_when_fail_to_receive_response() {
        // arrange
        Customer customer = Customer.builder()
                .firstName("Roland")
                .lastName("Salloum")
                .email("roland.salloum00@outlook.com")
                .id(UUID.randomUUID())
                .build();


        when(fraudClient.CheckIfFraud(any()))
                .thenReturn(new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));

        // assert & action
        assertThatThrownBy(() -> fraudHandler.checkIfFraud(customer))
                .isInstanceOf(NullPointerException.class);


    }

}