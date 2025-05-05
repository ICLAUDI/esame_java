package com.example.demo.Dto;

public class MaterialeDidatticoDTO {

    private Long idMateriale;
    private Long idCorso;
    private String titolo;
    private String descrizione;
    private String file;
    private String tipo;

    public MaterialeDidatticoDTO() {
    }

    public MaterialeDidatticoDTO(Long idMateriale, Long idCorso, String titolo, String descrizione, String file, String tipo) {
        this.idMateriale = idMateriale;
        this.idCorso = idCorso;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.file = file;
        this.tipo = tipo;
    }

    public Long getIdMateriale() {
        return idMateriale;
    }

    public void setIdMateriale(Long idMateriale) {
        this.idMateriale = idMateriale;
    }

    public Long getIdCorso() {
        return idCorso;
    }

    public void setIdCorso(Long idCorso) {
        this.idCorso = idCorso;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
