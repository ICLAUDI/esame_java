package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lezione")
public class Lezione {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lezione")
    private Long idLezione;
    
    @ManyToOne
    @JoinColumn(name = "id_corso", nullable = false)
    private Corso corso;
    
    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;
    
    @ManyToOne
    @JoinColumn(name = "id_aula", nullable = false)
    private Aula aula;
    
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column(name = "ora_inizio")
    private String oraInizio;
    
    @Column(name = "ora_fine")
    private String oraFine;
    
    @Column(name = "argomento")
    private String argomento;
    
    @OneToMany(mappedBy = "lezione")
    private List<Presenza> presenze;

    // Costruttori
    public Lezione() {
    }

    public Lezione(Corso corso, Docente docente, Aula aula, Date data, String oraInizio, String oraFine, String argomento) {
        this.corso = corso;
        this.docente = docente;
        this.aula = aula;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.argomento = argomento;
    }

    // Getter e Setter
    public Long getIdLezione() {
        return idLezione;
    }

    public void setIdLezione(Long idLezione) {
        this.idLezione = idLezione;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(String oraInizio) {
        this.oraInizio = oraInizio;
    }

    public String getOraFine() {
        return oraFine;
    }

    public void setOraFine(String oraFine) {
        this.oraFine = oraFine;
    }

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public List<Presenza> getPresenze() {
        return presenze;
    }

    public void setPresenze(List<Presenza> presenze) {
        this.presenze = presenze;
    }
}