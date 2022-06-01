package com.mbsystems.service;

import com.mbsystems.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record NotificationConsumerService(NotificationService notificationService) {

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);

        this.notificationService.send( notificationRequest );

    }
}
