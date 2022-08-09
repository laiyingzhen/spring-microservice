package com.simple.fraud.controller;

import com.simple.fraud.model.FraudCheckResponse;
import com.simple.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {
    private final FraudCheckService fraudCheckService;
    @GetMapping(path="{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId")Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("Fraud check for customer {}",customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
