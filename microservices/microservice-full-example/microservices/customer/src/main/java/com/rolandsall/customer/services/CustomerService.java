package com.rolandsall.customer.services;

import com.rolandsall.customer.api.customer.FraudResponse;
import com.rolandsall.customer.models.Customer;
import com.rolandsall.customer.respositories.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository iCustomerRepository;
    private final IHttpHandler httpHandler;

    @Autowired
    public CustomerService(ICustomerRepository iCustomerRepository, IHttpHandler httpHandler) {
        this.iCustomerRepository = iCustomerRepository;
        this.httpHandler = httpHandler;
    }


    @Override
    public void Register(Customer customer) {
        customer.setId(UUID.randomUUID());


        // check if fraud
        String url = "http://localhost:8081/api/v1/fraud-check/" + customer.getId();


        FraudResponse response = (FraudResponse) httpHandler.getForObject(url, FraudResponse.class);

        if (response.isFraud()) {
            throw new IllegalStateException("fraudster");
        }

        iCustomerRepository.save(customer);

    }

    @Override
    public List<Customer> GetUsers() {
        return iCustomerRepository.findAll();
    }
}
