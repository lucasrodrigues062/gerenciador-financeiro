package com.example.petshop.models;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cliente {

  @jakarta.persistence.Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  Long id;

  UUID idCliente;

  String nome;

  String email;
  @OneToMany(mappedBy = "dono", cascade = CascadeType.PERSIST)
  @JsonManagedReference
  List<Pet> pets;


  
}
