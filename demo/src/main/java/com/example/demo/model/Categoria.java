package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "descrizione")
    private String descrizione;
    
    @Column(name = "area_tematica")
    private String areaTematica;
    
    @OneToMany(mappedBy = "categoria")
    private List<Corso> corsi;

    // Costruttori
    public Categoria() {
    }

    public Categoria(String nome, String descrizione, String areaTematica) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.areaTematica = areaTematica;
    }

    // Getter e Setter
    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(String areaTematica) {
        this.areaTematica = areaTematica;
    }

    public List<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }

    @Override
    public String toString() {
        return nome;
    }
}