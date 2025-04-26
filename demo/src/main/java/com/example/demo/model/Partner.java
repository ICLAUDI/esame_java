package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "partner")
public class Partner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partner")
    private Long idPartner;
    
    @Column(name = "nome_azienda", nullable = false)
    private String nomeAzienda;
    
    @Column(name = "settore")
    private String settore;
    
    @Column(name = "indirizzo")
    private String indirizzo;
    
    @Column(name = "referente")
    private String referente;
    
    @Column(name = "telefono")
    private String telefono;
    
    @OneToMany(mappedBy = "partner")
    private List<Stage> stages;

    // Costruttori
    public Partner() {
    }

    public Partner(String nomeAzienda, String settore, String indirizzo, String referente, String telefono) {
        this.nomeAzienda = nomeAzienda;
        this.settore = settore;
        this.indirizzo = indirizzo;
        this.referente = referente;
        this.telefono = telefono;
    }

    // Getter e Setter
    public Long getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(Long idPartner) {
        this.idPartner = idPartner;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public String getSettore() {
        return settore;
    }

    public void setSettore(String settore) {
        this.settore = settore;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getReferente() {
        return referente;
    }

    public void setReferente(String referente) {
        this.referente = referente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    @Override
    public String toString() {
        return nomeAzienda;
    }
}