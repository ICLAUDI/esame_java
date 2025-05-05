package com.example.demo.Dto;

import java.util.List;

public class DocenteDTO {
    private Long idDocente;
    private String nome;
    private String cognome;
    private String email;
    private String password;        // <--- aggiunto
    private String telefono;
    private String specializzazione;
    private String ruolo;
    private List<Long> corsiIds;

    // Costruttore
    public DocenteDTO(Long idDocente, String nome, String cognome, String email, String password, String telefono,
                      String specializzazione, String ruolo, List<Long> corsiIds) {
        this.idDocente = idDocente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.specializzazione = specializzazione;
        this.ruolo = ruolo;
        this.corsiIds = corsiIds;
    }

    // Getter e Setter
    public Long getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Long idDocente) {
        this.idDocente = idDocente;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public List<Long> getCorsiIds() {
        return corsiIds;
    }

    public void setCorsiIds(List<Long> corsiIds) {
        this.corsiIds = corsiIds;
    }
}
