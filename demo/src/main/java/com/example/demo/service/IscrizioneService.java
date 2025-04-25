package com.example.demo.service;

import com.example.demo.model.Iscrizione;

import java.time.LocalDate;
import java.util.List;

public interface IscrizioneService {
    Iscrizione saveIscrizione(Iscrizione iscrizione);
    Iscrizione getIscrizioneById(Long id);
    List<Iscrizione> getIscrizioniByStudenteIdAndCorsoId(Long studenteId, Long corsoId);
    List<Iscrizione> getIscrizioniByDataIscrizioneBetween(LocalDate inizio, LocalDate fine);
    List<Iscrizione> getActiveIscrizioniByStudenteId(Long studenteId);
    Long countIscrizioniByCorsoId(Long corsoId);
    void deleteIscrizione(Long id);
    boolean existsById(Long id);
}
