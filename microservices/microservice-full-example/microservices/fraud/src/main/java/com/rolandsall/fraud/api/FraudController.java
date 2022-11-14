package com.rolandsall.fraud.api;
import com.rolandsall.client.fraud.FraudResponse;
import com.rolandsall.fraud.services.IFraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/v1/fraud-check")
public class FraudController {

    private IFraudCheckService iFraudCheckService;

    public FraudController(IFraudCheckService iFraudCheckService) {
        this.iFraudCheckService = iFraudCheckService;
    }

    @GetMapping("{customerId}")
    public ResponseEntity<FraudResponse> CheckIfFraud(@PathVariable("customerId") UUID customerId) {
        log.info(String.valueOf(customerId));
        boolean fraudCustomer = iFraudCheckService.isFraudCustomer(customerId);
        return ResponseEntity.ok().body(new FraudResponse(fraudCustomer));

    }
}
