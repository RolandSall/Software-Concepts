package com.rolandsall.fraud.api;


import com.rolandsall.fraud.services.IFraudCheckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/fraud-check")
public class FraudController {

    private IFraudCheckService iFraudCheckService;

    public FraudController(IFraudCheckService iFraudCheckService) {
        this.iFraudCheckService = iFraudCheckService;
    }

    @GetMapping("{customerId}")
    public ResponseEntity<FraudResponse> CheckIfFraud(@PathVariable("customerId") UUID customerId) {
        boolean fraudCustomer = iFraudCheckService.isFraudCustomer(customerId);
        return ResponseEntity.ok().body(new FraudResponse(fraudCustomer));

    }
}
