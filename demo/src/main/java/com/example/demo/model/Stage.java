package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "stage")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "data_inizio")
    private LocalDate dataInizio;
    
    @Column(name = "data_fine")
    private LocalDate dataFine;
    
    private String ruolo;
    
    @Column(columnDefinition = "TEXT")
    private String descrizione;
    
    private Boolean retribuito;
    
    // Relazioni
    @ManyToOne
    @JoinColumn(name = "id_partner", nullable = false)
    private PartnerAziendale partner;
    
    @ManyToOne
    @JoinColumn(name = "id_studente", nullable = false)
    private Studente studente;
}