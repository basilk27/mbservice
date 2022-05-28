package com.mbsystems.controller;

import com.mbsystems.model.CustomerRegistrationRequest;
import com.mbsystems.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping( "/api/v1/customers" )
public record CustomerController( CustomerService customerService ) {

    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest ) {
        log.info( "new customer registration {}", customerRegistrationRequest);
        this.customerService.registerCustomer( customerRegistrationRequest );
    }
}
