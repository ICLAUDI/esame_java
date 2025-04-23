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
@Table(name = "studenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Studente {
    
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
    
    @Past(message = "La data di nascita deve essere nel passato")
    private LocalDate dataNascita;
    
    private String indirizzo;
    
    private String titoloStudio;
    
    @Column(name = "data_iscrizione")
    private LocalDate dataIscrizione;
    
    // Relazioni
    @OneToMany(mappedBy = "studente", cascade = CascadeType.ALL)
    private Set<Iscrizione> iscrizioni = new HashSet<>();
    
    @OneToMany(mappedBy = "studente", cascade = CascadeType.ALL)
    private Set<Pagamento> pagamenti = new HashSet<>();
    
    @OneToMany(mappedBy = "studente", cascade = CascadeType.ALL)
    private Set<Feedback> feedback = new HashSet<>();
    
    @OneToMany(mappedBy = "studente", cascade = CascadeType.ALL)
    private Set<Stage> stage = new HashSet<>();
}
