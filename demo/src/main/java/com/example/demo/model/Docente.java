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
@Table(name = "docenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Docente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Il nome è obbligatorio")
    private String nome;
    
    @NotBlank(message = "Il cognome è obbligatorio")
    private String cognome;
    
    @Email(message = "Formato email non valido")
    @NotBlank(message = "L'email è obbligatoria")
    @Column(unique = true)
    private String email;
    
    private String telefono;
    
    private String specializzazione;
    
    @PositiveOrZero(message = "La tariffa oraria non può essere negativa")
    private Float tariffaOraria;
    
    private String cv;
    
    @Column(name = "data_assunzione")
    private LocalDate dataAssunzione;
    
    // Relazioni
    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    private Set<Corso> corsi = new HashSet<>();
    
    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    private Set<Lezione> lezioni = new HashSet<>();
    
    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    private Set<Valutazione> valutazioni = new HashSet<>();
}