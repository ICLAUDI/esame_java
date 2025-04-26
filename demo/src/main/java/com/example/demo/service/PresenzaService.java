package com.example.demo.service;

import com.example.demo.model.Presenza;
import com.example.demo.model.Lezione;
import com.example.demo.model.Iscrizione;

import java.util.List;
import java.util.Optional;

public interface PresenzaService {
    Presenza createPresenza(Presenza presenza);
    List<Presenza> getAllPresenze();
    Optional<Presenza> getPresenzaById(Long id);
    List<Presenza> getPresenzeByLezione(Lezione lezione);
    List<Presenza> getPresenzeByIscrizione(Iscrizione iscrizione);
    List<Presenza> getPresenzeByPresenza(Boolean presente);
    Presenza updatePresenza(Long id, Presenza presenza);
    void deletePresenza(Long id);
    Presenza getPresenzaByLezioneAndIscrizione(Lezione lezione, Iscrizione iscrizione);
    Integer countPresenzeByIscrizioneId(Long iscrizioneId);
    Integer countPresenzeByLezioneId(Long lezioneId);
}
