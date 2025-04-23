package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lezioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lezione {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "La data è obbligatoria")
    private LocalDate data;
    
    @Column(name = "ora_inizio")
    private LocalTime oraInizio;
    
    @Column(name = "ora_fine")
    private LocalTime oraFine;
    
    private String argomento;
    
    // Relazioni
    @ManyToOne
    @JoinColumn(name = "id_corso", nullable = false)
    private Corso corso;
    
    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;
    
    @ManyToOne
    @JoinColumn(name = "id_aula", nullable = false)
    private Aula aula;
    
    @OneToMany(mappedBy = "lezione", cascade = CascadeType.ALL)
    private Set<Presenza> presenze = new HashSet<>();
}