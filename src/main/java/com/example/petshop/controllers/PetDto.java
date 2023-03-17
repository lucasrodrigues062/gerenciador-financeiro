package com.example.petshop.controllers;

import com.example.petshop.models.Tipo;

public record PetDto(
String nome,
Tipo tipo,
Integer idade
) {
  
}
