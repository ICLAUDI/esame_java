package com.example.demo.service;

import com.example.demo.model.Lezione;
import com.example.demo.model.Corso;
import com.example.demo.model.Docente;
import com.example.demo.model.Aula;

import java.util.Date;
import java.util.List;

public interface LezioneService {
    List<Lezione> getAllLezioni();
    Lezione getLezioneById(Long id);
    Lezione createLezione(Lezione lezione);
    Lezione updateLezione(Long id, Lezione lezione);
    void deleteLezione(Long id);

    List<Lezione> getByCorso(Corso corso);
    List<Lezione> getByDocente(Docente docente);
    List<Lezione> getByAula(Aula aula);
    List<Lezione> getByData(Date data);
    List<Lezione> getByDataBetween(Date startDate, Date endDate);
    List<Lezione> getByArgomento(String argomento);
    List<Lezione> getByAulaAndDataAndTimeOverlap(Aula aula, Date data, String oraFine, String oraInizio);
}
