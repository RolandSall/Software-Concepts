package com.rolandsall.customer.services;

import com.rolandsall.customer.models.Customer;
import com.rolandsall.customer.respositories.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService implements ICustomerService {

    private ICustomerRepository iCustomerRepository;

    @Autowired
    public CustomerService(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public void Register(Customer customer) {
        customer.setId(UUID.randomUUID());
        iCustomerRepository.save(customer);
    }

    @Override
    public List<Customer> GetUsers() {
        return iCustomerRepository.findAll();
    }
}
