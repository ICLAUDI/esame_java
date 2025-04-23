package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "partner_aziendali")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerAziendale {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Il nome dell'azienda è obbligatorio")
    @Column(name = "nome_azienda")
    private String nomeAzienda;
    
    private String settore;
    
    private String indirizzo;
    
    private String referente;
    
    @Email(message = "Formato email non valido")
    private String email;
    
    private String telefono;
    
    // Relazioni
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    private Set<Stage> stage = new HashSet<>();
}