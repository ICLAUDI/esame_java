package com.example.demo.Dto;

import java.util.Date;

public class LezioneDTO {

    private Long idLezione;
    private Long idCorso;
    private Long idDocente;
    private Long idAula;
    private Date data;
    private String oraInizio;
    private String oraFine;
    private String argomento;

    public LezioneDTO() {
    }

    public LezioneDTO(Long idLezione, Long idCorso, Long idDocente, Long idAula, Date data, String oraInizio, String oraFine, String argomento) {
        this.idLezione = idLezione;
        this.idCorso = idCorso;
        this.idDocente = idDocente;
        this.idAula = idAula;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.argomento = argomento;
    }

    public Long getIdLezione() {
        return idLezione;
    }

    public void setIdLezione(Long idLezione) {
        this.idLezione = idLezione;
    }

    public Long getIdCorso() {
        return idCorso;
    }

    public void setIdCorso(Long idCorso) {
        this.idCorso = idCorso;
    }

    public Long getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Long idDocente) {
        this.idDocente = idDocente;
    }

    public Long getIdAula() {
        return idAula;
    }

    public void setIdAula(Long idAula) {
        this.idAula = idAula;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(String oraInizio) {
        this.oraInizio = oraInizio;
    }

    public String getOraFine() {
        return oraFine;
    }

    public void setOraFine(String oraFine) {
        this.oraFine = oraFine;
    }

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }
}
