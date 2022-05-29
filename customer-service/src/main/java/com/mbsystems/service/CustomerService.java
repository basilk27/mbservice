package com.mbsystems.service;

import com.mbsystems.entities.Customer;
import com.mbsystems.model.CustomerRegistrationRequest;
import com.mbsystems.model.FraudCheckResponse;
import com.mbsystems.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate ) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName( customerRegistrationRequest.firstName() )
                .lastName( customerRegistrationRequest.lastName() )
                .email( customerRegistrationRequest.email() )
                .build();

        //TODO check if email valid
        //TODO check if if email not taken
        //TODO check if fraudster

        this.customerRepository.saveAndFlush( customer );

        FraudCheckResponse fraudCheckResponse = restTemplate.
                getForObject("http://FRAUD-SERVICE/api/v1/fraud-check/{customerId}",
                                 FraudCheckResponse.class, customer.getId() );

        if ( fraudCheckResponse.isFraudster() ) {
            throw new IllegalStateException( "fraud - Invalid customer ID: " );
        }
        //TODO send notification
    }
}
