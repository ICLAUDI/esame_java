package com.example.demo.Dto;

import java.util.Date;

public class FeedbackDTO {
    private Long idFeedback;
    private Long idStudente;
    private Long idCorso;
    private Integer valutazione;
    private String commento;
    private Date dataFeedback;

    public FeedbackDTO() {
    }

    public FeedbackDTO(Long idFeedback, Long idStudente, Long idCorso, Integer valutazione, String commento, Date dataFeedback) {
        this.idFeedback = idFeedback;
        this.idStudente = idStudente;
        this.idCorso = idCorso;
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

    public Long getIdStudente() {
        return idStudente;
    }

    public void setIdStudente(Long idStudente) {
        this.idStudente = idStudente;
    }

    public Long getIdCorso() {
        return idCorso;
    }

    public void setIdCorso(Long idCorso) {
        this.idCorso = idCorso;
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
