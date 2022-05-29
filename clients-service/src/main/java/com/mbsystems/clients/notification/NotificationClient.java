package com.mbsystems.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification-service")
public interface NotificationClient {

    @PostMapping( path = "api/v1/notification")
    void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
