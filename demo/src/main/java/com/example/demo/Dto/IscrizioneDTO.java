package com.example.demo.Dto;

import java.util.Date;

public class IscrizioneDTO {
    private Long idIscrizione;
    private Long idStudente;
    private Long idCorso;
    private Date dataIscrizione;
    private String stato;
    private Double importoPagato;
    private Boolean completato;

    public IscrizioneDTO() {}

    public IscrizioneDTO(Long idIscrizione, Long idStudente, Long idCorso, Date dataIscrizione, String stato, Double importoPagato, Boolean completato) {
        this.idIscrizione = idIscrizione;
        this.idStudente = idStudente;
        this.idCorso = idCorso;
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
