package com.rolandsall.fraud.services;

import java.util.UUID;

public interface IFraudCheckService {

    public boolean isFraudCustomer(UUID customerId);

}
