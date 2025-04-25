package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "offerta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offerta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_offerta;
    
    @ManyToOne
    @JoinColumn(name = "id_partner", nullable = false)
    private PartnerAziendale partner;
    
    @Column(columnDefinition = "TEXT")
    private String descrizione;
    
    @Column(columnDefinition = "TEXT")
    private String requisiti;
    
    @Column(name = "data_pubblicazione")
    private LocalDate dataPubblicazione;
    
    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;
}