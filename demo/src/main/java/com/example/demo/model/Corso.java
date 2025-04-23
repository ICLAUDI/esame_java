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
@Table(name = "corsi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Corso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Il titolo è obbligatorio")
    private String titolo;
    
    @Column(columnDefinition = "TEXT")
    private String descrizione;
    
    @Positive(message = "La durata deve essere maggiore di zero")
    @Column(name = "durata_ore")
    private Integer durataOre;
    
    @PositiveOrZero(message = "Il costo non può essere negativo")
    private Float costo;
    
    @PositiveOrZero(message = "I posti disponibili non possono essere negativi")
    @Column(name = "posti_disponibili")
    private Integer postiDisponibili;
    
    @Column(name = "data_inizio")
    private LocalDate dataInizio;
    
    @Column(name = "data_fine")
    private LocalDate dataFine;
    
    private String livello;
    
    private Boolean certificazione;
    
    // Relazioni
    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
    
    @OneToMany(mappedBy = "corso", cascade = CascadeType.ALL)
    private Set<Iscrizione> iscrizioni = new HashSet<>();
    
    @OneToMany(mappedBy = "corso", cascade = CascadeType.ALL)
    private Set<Lezione> lezioni = new HashSet<>();
    
    @OneToMany(mappedBy = "corso", cascade = CascadeType.ALL)
    private Set<MaterialeDidattico> materialiDidattici = new HashSet<>();
    
    @OneToMany(mappedBy = "corso", cascade = CascadeType.ALL)
    private Set<Feedback> feedback = new HashSet<>();
}
