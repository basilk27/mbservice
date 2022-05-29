package com.mbsystems.controller;

import com.mbsystems.clients.fraud.FraudCheckResponse;
import com.mbsystems.service.FraudCheckHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping( "api/v1/fraud-check")
public record FraudCheckHistoryController(FraudCheckHistoryService  fraudCheckHistoryService ) {

    @GetMapping( path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId ) {
       Boolean isFraudulentCustomer = this.fraudCheckHistoryService.isFraudulentCustomer( customerId );

       log.info( "Fraud check request for customer {}", customerId);

       return new FraudCheckResponse( isFraudulentCustomer );
    }
}
