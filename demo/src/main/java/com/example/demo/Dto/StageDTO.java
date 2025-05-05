package com.example.demo.Dto;

import java.util.Date;

public class StageDTO {

    private Long idStage;
    private Long corsoId;
    private Long partnerId;
    private Long studenteId;
    private Date dataInizio;
    private Date dataFine;
    private String ruolo;
    private String descrizione;
    private Boolean retribuito;

    // Costruttori
    public StageDTO() {}

    public StageDTO(Long idStage, Long corsoId, Long partnerId, Long studenteId, Date dataInizio, Date dataFine, 
                    String ruolo, String descrizione, Boolean retribuito) {
        this.idStage = idStage;
        this.corsoId = corsoId;
        this.partnerId = partnerId;
        this.studenteId = studenteId;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.ruolo = ruolo;
        this.descrizione = descrizione;
        this.retribuito = retribuito;
    }

    // Getter e Setter
    public Long getIdStage() {
        return idStage;
    }

    public void setIdStage(Long idStage) {
        this.idStage = idStage;
    }

    public Long getCorsoId() {
        return corsoId;
    }

    public void setCorsoId(Long corsoId) {
        this.corsoId = corsoId;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Long getStudenteId() {
        return studenteId;
    }

    public void setStudenteId(Long studenteId) {
        this.studenteId = studenteId;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Boolean getRetribuito() {
        return retribuito;
    }

    public void setRetribuito(Boolean retribuito) {
        this.retribuito = retribuito;
    }
}
