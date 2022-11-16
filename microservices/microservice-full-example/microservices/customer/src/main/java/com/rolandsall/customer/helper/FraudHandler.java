package com.rolandsall.customer.helper;

import com.rolandsall.client.fraud.FraudClient;
import com.rolandsall.client.fraud.FraudResponse;
import com.rolandsall.customer.models.Customer;
import com.rolandsall.customer.services.IFraudHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FraudHandler implements IFraudHandler {


    private final FraudClient fraudClient;

    @Autowired
    public FraudHandler(FraudClient fraudClient) {
        this.fraudClient = fraudClient;
    }

    @Override
    public boolean checkIfFraud(Customer customer) {
        FraudResponse response = fraudClient.CheckIfFraud(customer.getId()).getBody();
        return Objects.requireNonNull(response).isFraud();
    }
}
