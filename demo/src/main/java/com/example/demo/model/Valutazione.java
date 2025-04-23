package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "valutazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Valutazione {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @DecimalMin(value = "0.0", message = "Il voto non può essere negativo")
    @DecimalMax(value = "10.0", message = "Il voto non può essere maggiore di 10")
    private Float voto;
    
    @Column(columnDefinition = "TEXT")
    private String commento;
    
    @Column(name = "data_valutazione")
    private LocalDate dataValutazione;
    
    @Column(name = "tipo_valutazione")
    private String tipoValutazione;
    
    // Relazioni
    @ManyToOne
    @JoinColumn(name = "id_iscrizione", nullable = false)
    private Iscrizione iscrizione;
    
    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;
}