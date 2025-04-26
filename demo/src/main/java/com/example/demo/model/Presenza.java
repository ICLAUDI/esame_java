package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "presenza")
public class Presenza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presenza")
    private Long idPresenza;
    
    @ManyToOne
    @JoinColumn(name = "id_lezione", nullable = false)
    private Lezione lezione;
    
    @ManyToOne
    @JoinColumn(name = "id_iscrizione", nullable = false)
    private Iscrizione iscrizione;
    
    @Column(name = "presente")
    private Boolean presente;
    
    @Column(name = "note")
    private String note;

    // Costruttori
    public Presenza() {
    }

    public Presenza(Lezione lezione, Iscrizione iscrizione, Boolean presente, String note) {
        this.lezione = lezione;
        this.iscrizione = iscrizione;
        this.presente = presente;
        this.note = note;
    }

    // Getter e Setter
    public Long getIdPresenza() {
        return idPresenza;
    }

    public void setIdPresenza(Long idPresenza) {
        this.idPresenza = idPresenza;
    }

    public Lezione getLezione() {
        return lezione;
    }

    public void setLezione(Lezione lezione) {
        this.lezione = lezione;
    }

    public Iscrizione getIscrizione() {
        return iscrizione;
    }

    public void setIscrizione(Iscrizione iscrizione) {
        this.iscrizione = iscrizione;
    }

    public Boolean getPresente() {
        return presente;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}