package com.rolandsall.customer.services;

import com.rolandsall.customer.models.Customer;

public interface IFraudHandler {
    boolean checkIfFraud(Customer customer);
}
