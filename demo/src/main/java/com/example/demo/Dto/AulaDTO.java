package com.example.demo.Dto;

public class AulaDTO {
    private Long idAula;
    private String nome;
    private Integer capacita;
    private String edificio;
    private String attrezzature;
    private Boolean accessibile;

    // Costruttori
    public AulaDTO() {
    }

    public AulaDTO(Long idAula, String nome, Integer capacita, String edificio, String attrezzature, Boolean accessibile) {
        this.idAula = idAula;
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
}
