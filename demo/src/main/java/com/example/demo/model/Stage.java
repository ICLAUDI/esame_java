package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stage")
public class Stage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stage")
    private Long idStage;
    
    @ManyToOne
    @JoinColumn(name = "id_corso", nullable = false)
    private Corso corso;
    
    @ManyToOne
    @JoinColumn(name = "id_partner", nullable = false)
    private Partner partner;
    
    @ManyToOne
    @JoinColumn(name = "id_studente", nullable = false)
    private Studente studente;
    
    @Column(name = "data_inizio")
    @Temporal(TemporalType.DATE)
    private Date dataInizio;
    
    @Column(name = "data_fine")
    @Temporal(TemporalType.DATE)
    private Date dataFine;
    
    @Column(name = "ruolo")
    private String ruolo;
    
    @Column(name = "descrizione")
    private String descrizione;
    
    @Column(name = "retribuito")
    private Boolean retribuito;

    // Costruttori
    public Stage() {
    }

    public Stage(Corso corso, Partner partner, Studente studente, Date dataInizio, Date dataFine, 
                String ruolo, String descrizione, Boolean retribuito) {
        this.corso = corso;
        this.partner = partner;
        this.studente = studente;
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

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Studente getStudente() {
        return studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
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