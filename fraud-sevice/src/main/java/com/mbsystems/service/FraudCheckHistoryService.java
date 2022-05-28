package com.mbsystems.service;

import com.mbsystems.entity.FraudCheckHistory;
import com.mbsystems.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckHistoryService(FraudCheckHistoryRepository fraudCheckHistoryRepository ) {

    public Boolean isFraudulentCustomer( Integer customerId ) {
        this.fraudCheckHistoryRepository.save( FraudCheckHistory.builder()
                .customerId( customerId )
                .isFraudster( Boolean.FALSE )
                .createdAt( LocalDateTime.now() )
                .build() );

        return Boolean.FALSE;
    }
}
