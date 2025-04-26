package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feedback")
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feedback")
    private Long idFeedback;
    
    @ManyToOne
    @JoinColumn(name = "id_studente", nullable = false)
    private Studente studente;
    
    @ManyToOne
    @JoinColumn(name = "id_corso", nullable = false)
    private Corso corso;
    
    @Column(name = "valutazione")
    private Integer valutazione;
    
    @Column(name = "commento")
    private String commento;
    
    @Column(name = "data_feedback")
    @Temporal(TemporalType.DATE)
    private Date dataFeedback;

    // Costruttori
    public Feedback() {
    }

    public Feedback(Studente studente, Corso corso, Integer valutazione, String commento, Date dataFeedback) {
        this.studente = studente;
        this.corso = corso;
        this.valutazione = valutazione;
        this.commento = commento;
        this.dataFeedback = dataFeedback;
    }

    // Getter e Setter
    public Long getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Long idFeedback) {
        this.idFeedback = idFeedback;
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

    public Integer getValutazione() {
        return valutazione;
    }

    public void setValutazione(Integer valutazione) {
        this.valutazione = valutazione;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public Date getDataFeedback() {
        return dataFeedback;
    }

    public void setDataFeedback(Date dataFeedback) {
        this.dataFeedback = dataFeedback;
    }
}
