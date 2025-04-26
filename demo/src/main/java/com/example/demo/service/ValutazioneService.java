package com.example.demo.service;

import com.example.demo.model.Valutazione;
import com.example.demo.model.Iscrizione;
import com.example.demo.model.Docente;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ValutazioneService {
    Valutazione createValutazione(Valutazione valutazione);
    List<Valutazione> getAllValutazioni();
    Optional<Valutazione> getValutazioneById(Long id);
    List<Valutazione> getValutazioniByIscrizione(Iscrizione iscrizione);
    List<Valutazione> getValutazioniByDocente(Docente docente);
    List<Valutazione> getValutazioniByVotoRange(Integer minVoto, Integer maxVoto);
    List<Valutazione> getValutazioniByDataValutazione(Date startDate, Date endDate);
    List<Valutazione> getValutazioniByTipoValutazione(String tipoValutazione);
    Double getAverageVotoByIscrizioneId(Long iscrizioneId);
    Double getAverageVotoByCorsoId(Long corsoId);
    Valutazione updateValutazione(Long id, Valutazione valutazione);
    void deleteValutazione(Long id);
}
