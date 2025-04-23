package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "iscrizioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Iscrizione {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "data_iscrizione")
    private LocalDate dataIscrizione;
    
    private String stato;
    
    @PositiveOrZero(message = "L'importo pagato non può essere negativo")
    @Column(name = "importo_pagato")
    private Float importoPagato;
    
    private Boolean completato;
    
    // Relazioni
    @ManyToOne
    @JoinColumn(name = "id_studente", nullable = false)
    private Studente studente;
    
    @ManyToOne
    @JoinColumn(name = "id_corso", nullable = false)
    private Corso corso;
    
    @OneToMany(mappedBy = "iscrizione", cascade = CascadeType.ALL)
    private Set<Valutazione> valutazioni = new HashSet<>();
    
    @OneToMany(mappedBy = "iscrizione", cascade = CascadeType.ALL)
    private Set<Presenza> presenze = new HashSet<>();
}
