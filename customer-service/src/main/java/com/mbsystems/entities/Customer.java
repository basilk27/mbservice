package com.mbsystems.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor( access = AccessLevel.PUBLIC, force = true )
@Entity
@Table(name = "customer", schema = "public")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
}
