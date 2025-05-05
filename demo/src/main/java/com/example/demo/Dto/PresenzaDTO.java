package com.example.demo.Dto;

public class PresenzaDTO {
    private Long idPresenza;
    private Long idLezione;
    private Long idIscrizione;
    private Boolean presente;
    private String note;

    // Getters e Setters
    public Long getIdPresenza() {
        return idPresenza;
    }

    public void setIdPresenza(Long idPresenza) {
        this.idPresenza = idPresenza;
    }

    public Long getIdLezione() {
        return idLezione;
    }

    public void setIdLezione(Long idLezione) {
        this.idLezione = idLezione;
    }

    public Long getIdIscrizione() {
        return idIscrizione;
    }

    public void setIdIscrizione(Long idIscrizione) {
        this.idIscrizione = idIscrizione;
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
