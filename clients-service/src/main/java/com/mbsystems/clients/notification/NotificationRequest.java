package com.mbsystems.clients.notification;

public record NotificationRequest( Integer customerId, String customerName, String message ) {
}
