package com.mbsystems.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor( access = AccessLevel.PUBLIC, force = true)
@Getter
@Table(name = "notification", schema = "public")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Integer notificationId;
    private final Integer toCustomerId;
    private final String toCustomerEmail;
    private final String sender;
    private final String message;
    private final LocalDateTime sentAt;
}
