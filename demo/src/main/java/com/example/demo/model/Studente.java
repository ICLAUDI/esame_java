package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "studente")
public class Studente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_studente")
    private Long idStudente;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "cognome", nullable = false)
    private String cognome;
    
    @Column(name = "email", nullable = false)
    private String email;
    
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
    
    @OneToMany(mappedBy = "studente")
    private List<Iscrizione> iscrizioni;
    
    @OneToMany(mappedBy = "studente")
    private List<Pagamento> pagamenti;
    
    @OneToMany(mappedBy = "studente")
    private List<Feedback> feedbacks;

    // Costruttori
    public Studente() {
    }

    public Studente(String nome, String cognome, String email, String telefono, Date dataNascita, 
                    String indirizzo, String titoloStudio, Date dataIscrizione) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
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

    public List<Iscrizione> getIscrizioni() {
        return iscrizioni;
    }

    public void setIscrizioni(List<Iscrizione> iscrizioni) {
        this.iscrizioni = iscrizioni;
    }

    public List<Pagamento> getPagamenti() {
        return pagamenti;
    }

    public void setPagamenti(List<Pagamento> pagamenti) {
        this.pagamenti = pagamenti;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}