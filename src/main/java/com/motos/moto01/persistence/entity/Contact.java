package com.motos.moto01.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_generator")
    @SequenceGenerator(name = "contact_generator", allocationSize = 1)
    private Long id;

    //@NotEmpty(message = "The name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    //@NotEmpty(message = "The last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "creation_date") //fehca de creacion CreatedDate
    private String creationDate;
}
