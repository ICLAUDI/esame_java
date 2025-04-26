package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "aula")
public class Aula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private Long idAula;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "capacità")
    private Integer capacita;
    
    @Column(name = "edificio")
    private String edificio;
    
    @Column(name = "attrezzature")
    private String attrezzature;
    
    @Column(name = "accessibile")
    private Boolean accessibile;
    
    @OneToMany(mappedBy = "aula")
    private List<Lezione> lezioni;

    // Costruttori
    public Aula() {
    }

    public Aula(String nome, Integer capacita, String edificio, String attrezzature, Boolean accessibile) {
        this.nome = nome;
        this.capacita = capacita;
        this.edificio = edificio;
        this.attrezzature = attrezzature;
        this.accessibile = accessibile;
    }

    // Getter e Setter
    public Long getIdAula() {
        return idAula;
    }

    public void setIdAula(Long idAula) {
        this.idAula = idAula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacita() {
        return capacita;
    }

    public void setCapacita(Integer capacita) {
        this.capacita = capacita;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getAttrezzature() {
        return attrezzature;
    }

    public void setAttrezzature(String attrezzature) {
        this.attrezzature = attrezzature;
    }

    public Boolean getAccessibile() {
        return accessibile;
    }

    public void setAccessibile(Boolean accessibile) {
        this.accessibile = accessibile;
    }

    public List<Lezione> getLezioni() {
        return lezioni;
    }

    public void setLezioni(List<Lezione> lezioni) {
        this.lezioni = lezioni;
    }

    @Override
    public String toString() {
        return nome;
    }
}