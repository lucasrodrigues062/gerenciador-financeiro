package com.example.petshop.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshop.models.Cliente;
import com.example.petshop.models.Pet;
import com.example.petshop.repository.ClienteRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class DonoController {

  private final ClienteRepository repository;

  public DonoController(ClienteRepository repository) {
    this.repository = repository;
  }

  @PostMapping()
  public Cliente cadastra(@RequestBody @Valid ClienteDto request) {

    Cliente cliente = Cliente.builder().email(request.email()).nome(request.nome()).idCliente(UUID.randomUUID())
        .build();
    if (!Objects.isNull(request.pet())) {
      Pet pet = Pet.builder()
          .nome(request.pet().nome())
          .idade(request.pet().idade())
          .tipo(request.pet().tipo())
          .dono(cliente)
          .build();
      List<Pet> pets = new ArrayList<>();
      pets.add(pet);
      cliente.setPets(pets);
    }
    
    repository.save(cliente);
    return cliente;

  }

}
