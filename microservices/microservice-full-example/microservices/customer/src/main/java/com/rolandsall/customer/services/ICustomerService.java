package com.rolandsall.customer.services;

import com.rolandsall.customer.models.Customer;

import java.util.List;

public interface ICustomerService {
    void Register(Customer customer);

    List<Customer> GetUsers();

}
