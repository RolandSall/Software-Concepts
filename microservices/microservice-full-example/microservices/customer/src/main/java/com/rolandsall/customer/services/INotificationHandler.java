package com.rolandsall.customer.services;

import com.rolandsall.customer.models.Customer;

public interface INotificationHandler {
    void publish(Customer customer);
}
