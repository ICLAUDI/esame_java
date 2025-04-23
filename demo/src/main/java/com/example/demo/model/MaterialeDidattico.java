package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "materiali_didattici")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialeDidattico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Il titolo è obbligatorio")
    private String titolo;
    
    @Column(columnDefinition = "TEXT")
    private String descrizione;
    
    private String tipo;
    
    private String url;
    
    @Column(name = "data_pubblicazione")
    private LocalDate dataPubblicazione;
    
    // Relazioni
    @ManyToOne
    @JoinColumn(name = "id_corso", nullable = false)
    private Corso corso;
}