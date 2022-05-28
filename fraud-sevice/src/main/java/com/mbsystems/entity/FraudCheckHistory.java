package com.mbsystems.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor( access = AccessLevel.PUBLIC, force = true )
@AllArgsConstructor
@Getter
@Entity
@Table(name = "fraud", schema = "public")
public class FraudCheckHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Integer id;
    private final Integer customerId;
    private final Boolean isFraudster;
    private final LocalDateTime createdAt;
}
