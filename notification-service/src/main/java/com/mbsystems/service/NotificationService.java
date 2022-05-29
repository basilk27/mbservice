package com.mbsystems.service;

import com.mbsystems.clients.notification.NotificationRequest;
import com.mbsystems.entities.Notification;
import com.mbsystems.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.customerId())
                        .toCustomerEmail(notificationRequest.customerName())
                        .sender("Amigoscode-bmk")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
