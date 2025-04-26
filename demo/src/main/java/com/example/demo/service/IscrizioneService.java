package com.example.demo.service;

import com.example.demo.model.Iscrizione;
import com.example.demo.model.Corso;
import com.example.demo.model.Studente;

import java.util.Date;
import java.util.List;

public interface IscrizioneService {
    List<Iscrizione> getAllIscrizioni();
    Iscrizione getIscrizioneById(Long id);
    Iscrizione createIscrizione(Iscrizione iscrizione);
    Iscrizione updateIscrizione(Long id, Iscrizione iscrizione);
    void deleteIscrizione(Long id);

    List<Iscrizione> getByStudente(Studente studente);
    List<Iscrizione> getByCorso(Corso corso);
    List<Iscrizione> getByDateRange(Date start, Date end);
    List<Iscrizione> getByStato(String stato);
    List<Iscrizione> getByCompletato(Boolean completato);
    Integer countByCorsoId(Long corsoId);
    List<Iscrizione> getByStudenteAndCorso(Studente studente, Corso corso);
}
