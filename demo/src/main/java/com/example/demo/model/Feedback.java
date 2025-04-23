package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Min(value = 1, message = "La valutazione deve essere tra 1 e 5")
    @Max(value = 5, message = "La valutazione deve essere tra 1 e 5")
    private Integer valutazione;
    
    @Column(columnDefinition = "TEXT")
    private String commento;
    
    @Column(name = "data_feedback")
    private LocalDate dataFeedback;
    
    // Relazioni
    @ManyToOne
    @JoinColumn(name = "id_studente", nullable = false)
    private Studente studente;
    
    @ManyToOne
    @JoinColumn(name = "id_corso", nullable = false)
    private Corso corso;
}