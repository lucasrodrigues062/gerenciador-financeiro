package com.example.petshop.controllers;

import com.example.petshop.models.Cliente;
import com.example.petshop.validations.UniqueValue;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

record ClienteDto(
@NotBlank  
    String nome,
@Email @NotBlank @UniqueValue(domainClass = Cliente.class, fieldName = "email")
String email,
        PetDto pet

) {}
