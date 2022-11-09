package com.rolandsall.customer.services;

import com.rolandsall.customer.models.Customer;
import com.rolandsall.customer.respositories.customer.ICustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private ICustomerRepository iCustomerRepository;
    private ICustomerService ICustomerService;

    @BeforeEach
    void setUp() {
        ICustomerService = new CustomerService(iCustomerRepository);
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

        // action
        ICustomerService.Register(customer);


        // assert
        ArgumentCaptor<Customer> studentArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(iCustomerRepository).save(studentArgumentCaptor.capture());
        Customer captorValue = studentArgumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(customer);



    }
}