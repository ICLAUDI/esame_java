package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "valutazione")
public class Valutazione {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valutazione")
    private Long idValutazione;
    
    @ManyToOne
    @JoinColumn(name = "id_iscrizione", nullable = false)
    private Iscrizione iscrizione;
    
    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;
    
    @Column(name = "voto")
    private Integer voto;
    
    @Column(name = "commento")
    private String commento;
    
    @Column(name = "data_valutazione")
    @Temporal(TemporalType.DATE)
    private Date dataValutazione;
    
    @Column(name = "tipo_valutazione")
    private String tipoValutazione;

    // Costruttori
    public Valutazione() {
    }

    public Valutazione(Iscrizione iscrizione, Docente docente, Integer voto, String commento, Date dataValutazione, String tipoValutazione) {
        this.iscrizione = iscrizione;
        this.docente = docente;
        this.voto = voto;
        this.commento = commento;
        this.dataValutazione = dataValutazione;
        this.tipoValutazione = tipoValutazione;
    }

    // Getter e Setter
    public Long getIdValutazione() {
        return idValutazione;
    }

    public void setIdValutazione(Long idValutazione) {
        this.idValutazione = idValutazione;
    }

    public Iscrizione getIscrizione() {
        return iscrizione;
    }

    public void setIscrizione(Iscrizione iscrizione) {
        this.iscrizione = iscrizione;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public Date getDataValutazione() {
        return dataValutazione;
    }

    public void setDataValutazione(Date dataValutazione) {
        this.dataValutazione = dataValutazione;
    }

    public String getTipoValutazione() {
        return tipoValutazione;
    }

    public void setTipoValutazione(String tipoValutazione) {
        this.tipoValutazione = tipoValutazione;
    }
}