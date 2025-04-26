package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "iscrizione")
public class Iscrizione {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_iscrizione")
    private Long idIscrizione;
    
    @ManyToOne
    @JoinColumn(name = "id_studente", nullable = false)
    private Studente studente;
    
    @ManyToOne
    @JoinColumn(name = "id_corso", nullable = false)
    private Corso corso;
    
    @Column(name = "data_iscrizione")
    @Temporal(TemporalType.DATE)
    private Date dataIscrizione;
    
    @Column(name = "stato")
    private String stato;
    
    @Column(name = "importo_pagato")
    private Double importoPagato;
    
    @Column(name = "completato")
    private Boolean completato;

    // Costruttori
    public Iscrizione() {
    }

    public Iscrizione(Studente studente, Corso corso, Date dataIscrizione, String stato, Double importoPagato, Boolean completato) {
        this.studente = studente;
        this.corso = corso;
        this.dataIscrizione = dataIscrizione;
        this.stato = stato;
        this.importoPagato = importoPagato;
        this.completato = completato;
    }

    // Getter e Setter
    public Long getIdIscrizione() {
        return idIscrizione;
    }

    public void setIdIscrizione(Long idIscrizione) {
        this.idIscrizione = idIscrizione;
    }

    public Studente getStudente() {
        return studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    public Date getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(Date dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Double getImportoPagato() {
        return importoPagato;
    }

    public void setImportoPagato(Double importoPagato) {
        this.importoPagato = importoPagato;
    }

    public Boolean getCompletato() {
        return completato;
    }

    public void setCompletato(Boolean completato) {
        this.completato = completato;
    }
}
