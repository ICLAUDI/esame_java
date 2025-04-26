package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "corso")
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corso")
    private Long idCorso;

    @Column(name = "titolo", nullable = false)
    private String titolo;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "durata")
    private Integer durata;

    @ManyToOne
    @JoinColumn(name = "id_categoria")  // Nome della colonna che fa riferimento alla categoria
    private Categoria categoria;  // Aggiungi questa proprietà per fare il mapping

    @ManyToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @Column(name = "data_inizio")
    @Temporal(TemporalType.DATE)
    private Date dataInizio;

    @Column(name = "data_fine")
    @Temporal(TemporalType.DATE)
    private Date dataFine;

    @Column(name = "posti_disponibili") // Aggiungi questa proprietà
    private Integer postiDisponibili; // Numero di posti disponibili nel corso

    // Costruttori
    public Corso() {}

    public Corso(String titolo, String descrizione, Integer durata, Categoria categoria, Docente docente, Date dataInizio, Date dataFine, Integer postiDisponibili) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.durata = durata;
        this.categoria = categoria;
        this.docente = docente;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.postiDisponibili = postiDisponibili; // Inizializza anche il nuovo campo
    }

    // Getter e Setter
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

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
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

    public Integer getPostiDisponibili() {
        return postiDisponibili;
    }

    public void setPostiDisponibili(Integer postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    @Override
    public String toString() {
        return titolo;
    }
}
