package com.example.petshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    Integer idade;

    @Enumerated(EnumType.STRING)
    Tipo tipo;

     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "cliente_id")
     @JsonBackReference
     Cliente dono;




  
}
