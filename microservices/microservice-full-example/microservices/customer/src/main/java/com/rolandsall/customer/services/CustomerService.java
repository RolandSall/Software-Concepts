package com.rolandsall.customer.services;

import com.rolandsall.client.fraud.FraudClient;
import com.rolandsall.client.fraud.FraudResponse;
import com.rolandsall.customer.models.Customer;
import com.rolandsall.customer.respositories.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository iCustomerRepository;

    private final FraudClient fraudClient;

    @Autowired
    public CustomerService(ICustomerRepository iCustomerRepository, FraudClient fraudClient) {
        this.iCustomerRepository = iCustomerRepository;
        this.fraudClient = fraudClient;
    }


    @Override
    public void Register(Customer customer) {
        customer.setId(UUID.randomUUID());

        FraudResponse response = fraudClient.CheckIfFraud(customer.getId()).getBody();

        if (Objects.requireNonNull(response).isFraud()) {
            throw new IllegalStateException("fraudster");
        }

        iCustomerRepository.save(customer);

    }

    @Override
    public List<Customer> GetUsers() {
        return iCustomerRepository.findAll();
    }
}
