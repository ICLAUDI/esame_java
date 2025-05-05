package com.example.demo.Dto;

public class CategoriaDTO {
    private Long idCategoria;
    private String nome;
    private String descrizione;
    private String areaTematica;

    // Costruttori
    public CategoriaDTO() {
    }

    public CategoriaDTO(Long idCategoria, String nome, String descrizione, String areaTematica) {
        this.idCategoria = idCategoria;
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
}
