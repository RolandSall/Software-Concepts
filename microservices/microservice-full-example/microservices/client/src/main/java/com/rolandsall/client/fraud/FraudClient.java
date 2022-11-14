package com.rolandsall.client.fraud;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        value = "fraud",
        path = "api/v1/fraud-check"
)
public interface FraudClient {

    @GetMapping("{customerId}")
    ResponseEntity<FraudResponse> CheckIfFraud(@PathVariable("customerId") UUID customerId);
}
