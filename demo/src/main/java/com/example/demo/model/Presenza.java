package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "presenze")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Presenza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Boolean presente;
    
    private String note;
    
    // Relazioni
    @ManyToOne
    @JoinColumn(name = "id_lezione", nullable = false)
    private Lezione lezione;
    
    @ManyToOne
    @JoinColumn(name = "id_iscrizione", nullable = false)
    private Iscrizione iscrizione;
}