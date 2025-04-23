package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "aule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Il nome è obbligatorio")
    private String nome;
    
    @Positive(message = "La capacità deve essere maggiore di zero")
    private Integer capacita;
    
    private String edificio;
    
    private String attrezzature;
    
    private Boolean accessibile;
    
    // Relazioni
    @OneToMany(mappedBy = "aula", cascade = CascadeType.ALL)
    private Set<Lezione> lezioni = new HashSet<>();
}