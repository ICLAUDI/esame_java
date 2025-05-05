package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "studenti")
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudente;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "ruolo", nullable = false)
    private String ruolo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "data_nascita")
    @Temporal(TemporalType.DATE)
    private Date dataNascita;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "titolo_studio")
    private String titoloStudio;

    @Column(name = "data_iscrizione")
    @Temporal(TemporalType.DATE)
    private Date dataIscrizione;

    // Costruttori
    public Studente() {
    }

    public Studente(Long idStudente, String nome, String cognome, String email, String password, String ruolo, String telefono,
                    Date dataNascita, String indirizzo, String titoloStudio, Date dataIscrizione) {
        this.idStudente = idStudente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.ruolo = ruolo;
        this.telefono = telefono;
        this.dataNascita = dataNascita;
        this.indirizzo = indirizzo;
        this.titoloStudio = titoloStudio;
        this.dataIscrizione = dataIscrizione;
    }

    // Getter e Setter
    public Long getIdStudente() {
        return idStudente;
    }

    public void setIdStudente(Long idStudente) {
        this.idStudente = idStudente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTitoloStudio() {
        return titoloStudio;
    }

    public void setTitoloStudio(String titoloStudio) {
        this.titoloStudio = titoloStudio;
    }

    public Date getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(Date dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }
}
