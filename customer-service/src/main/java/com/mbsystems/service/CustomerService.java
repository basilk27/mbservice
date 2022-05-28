package com.mbsystems.service;

import com.mbsystems.entities.Customer;
import com.mbsystems.model.CustomerRegistrationRequest;
import com.mbsystems.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService( CustomerRepository customerRepository ) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName( customerRegistrationRequest.firstName() )
                .lastName( customerRegistrationRequest.lastName() )
                .email( customerRegistrationRequest.email() )
                .build();

        //TODO check if email valid
        //TODO check if if email not taken
        this.customerRepository.save( customer );
    }
}
