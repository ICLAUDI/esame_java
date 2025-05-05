package com.example.demo.Dto;

import java.util.Date;

public class ValutazioneDTO {

    private Long idValutazione;
    private Long idIscrizione;
    private Long idDocente;
    private Integer voto;
    private String commento;
    private Date dataValutazione;
    private String tipoValutazione;

    // Costruttori, Getter e Setter
    public ValutazioneDTO() {}

    public ValutazioneDTO(Long idValutazione, Long idIscrizione, Long idDocente, Integer voto, String commento, Date dataValutazione, String tipoValutazione) {
        this.idValutazione = idValutazione;
        this.idIscrizione = idIscrizione;
        this.idDocente = idDocente;
        this.voto = voto;
        this.commento = commento;
        this.dataValutazione = dataValutazione;
        this.tipoValutazione = tipoValutazione;
    }

    public Long getIdValutazione() {
        return idValutazione;
    }

    public void setIdValutazione(Long idValutazione) {
        this.idValutazione = idValutazione;
    }

    public Long getIdIscrizione() {
        return idIscrizione;
    }

    public void setIdIscrizione(Long idIscrizione) {
        this.idIscrizione = idIscrizione;
    }

    public Long getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Long idDocente) {
        this.idDocente = idDocente;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public Date getDataValutazione() {
        return dataValutazione;
    }

    public void setDataValutazione(Date dataValutazione) {
        this.dataValutazione = dataValutazione;
    }

    public String getTipoValutazione() {
        return tipoValutazione;
    }

    public void setTipoValutazione(String tipoValutazione) {
        this.tipoValutazione = tipoValutazione;
    }
}
