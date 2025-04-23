package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "pagamenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @PositiveOrZero(message = "L'importo non può essere negativo")
    private Float importo;
    
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;
    
    @Column(name = "metodo_pagamento")
    private String metodoPagamento;
    
    private String stato;
    
    private String riferimento;
    
    // Relazioni
    @ManyToOne
    @JoinColumn(name = "id_studente", nullable = false)
    private Studente studente;
}