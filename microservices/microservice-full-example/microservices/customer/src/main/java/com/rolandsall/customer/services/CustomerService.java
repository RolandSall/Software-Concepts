package com.rolandsall.customer.services;

import com.rolandsall.customer.api.customer.FraudResponse;
import com.rolandsall.customer.models.Customer;
import com.rolandsall.customer.respositories.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository iCustomerRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public CustomerService(ICustomerRepository iCustomerRepository, RestTemplate restTemplate) {
        this.iCustomerRepository = iCustomerRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public void Register(Customer customer) {
        customer.setId(UUID.randomUUID());

        iCustomerRepository.saveAndFlush(customer);

        // check if fraud
        FraudResponse response = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/" + customer.getId(),
                FraudResponse.class
        );

        if (response.isFraud()) {
            throw new IllegalStateException("fraudster");
        }
    }

    @Override
    public List<Customer> GetUsers() {
        return iCustomerRepository.findAll();
    }
}
