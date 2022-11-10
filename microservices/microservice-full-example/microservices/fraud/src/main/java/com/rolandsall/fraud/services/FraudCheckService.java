package com.rolandsall.fraud.services;

import com.rolandsall.fraud.models.FraudCheckHistory;
import com.rolandsall.fraud.repositories.FraudCheckHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FraudCheckService implements IFraudCheckService{


    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Autowired
    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }

    @Override
    public boolean isFraudCustomer(UUID customerId) {
        // certain logic to decide if fraud or not
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                        .customerId(customerId)
                        .createdAt(LocalDateTime.now())
                        .id(UUID.randomUUID())
                        .isFraud(false)
                .build());

        return false;
    }
}
