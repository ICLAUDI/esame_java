package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "materiale_didattico")
public class MaterialeDidattico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materiale")
    private Long idMateriale;
    
    @ManyToOne
    @JoinColumn(name = "id_corso", nullable = false)
    private Corso corso;
    
    @Column(name = "titolo", nullable = false)
    private String titolo;
    
    @Column(name = "descrizione")
    private String descrizione;
    
    @Column(name = "file")
    private String file;
    
    @Column(name = "tipo")
    private String tipo;

    // Costruttori
    public MaterialeDidattico() {
    }

    public MaterialeDidattico(Corso corso, String titolo, String descrizione, String file, String tipo) {
        this.corso = corso;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.file = file;
        this.tipo = tipo;
    }

    // Getter e Setter
    public Long getIdMateriale() {
        return idMateriale;
    }

    public void setIdMateriale(Long idMateriale) {
        this.idMateriale = idMateriale;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
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

    @Override
    public String toString() {
        return titolo;
    }
}