package com.motos.moto01.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ContactInDTO {

    private Long id;

    @NotEmpty(message = "The name is required")   
    private String firstName;
    
    @NotEmpty(message = "The lastname is required")
    private String lastName;
}
