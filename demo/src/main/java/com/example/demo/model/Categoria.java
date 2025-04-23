package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categorie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Il nome è obbligatorio")
    @Column(unique = true)
    private String nome;
    
    private String descrizione;
    
    @Column(name = "area_tematica")
    private String areaTematica;
    
    // Relazioni
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private Set<Corso> corsi = new HashSet<>();
}