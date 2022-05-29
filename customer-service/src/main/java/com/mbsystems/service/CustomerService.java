package com.mbsystems.service;

import com.mbsystems.clients.fraud.FraudCheckResponse;
import com.mbsystems.clients.fraud.FraudClient;
import com.mbsystems.clients.notification.NotificationClient;
import com.mbsystems.clients.notification.NotificationRequest;
import com.mbsystems.entities.Customer;
import com.mbsystems.model.CustomerRegistrationRequest;
import com.mbsystems.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              RestTemplate restTemplate,
                              FraudClient fraudClient,
                              NotificationClient notificationClient ) {
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

        FraudCheckResponse fraudCheckResponse = this.fraudClient.isFraudster( customer.getId() );

        if ( fraudCheckResponse.isFraudster() ) {
            throw new IllegalStateException( "fraud - Invalid customer ID: " );
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Amigoscode-BMK...",
                        customer.getFirstName())
        );

        this.notificationClient.sendNotification( notificationRequest );
    }
}
