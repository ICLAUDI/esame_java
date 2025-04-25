package com.example.demo.service;

import com.example.demo.model.Valutazione;

import java.util.List;

public interface ValutazioneService {
    Valutazione saveValutazione(Valutazione valutazione);
    Valutazione getValutazioneById(Long id);
    List<Valutazione> getValutazioniByStudenteId(Long studenteId);
    List<Valutazione> getValutazioniByCorsoId(Long corsoId);
    Double getAverageVotoByCorsoId(Long corsoId);
    List<Valutazione> getValutazioniWithHighVoto(Double votoMinimo);
    void deleteValutazione(Long id);
    boolean existsById(Long id);
}
