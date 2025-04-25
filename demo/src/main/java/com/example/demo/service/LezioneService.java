package com.example.demo.service;

import com.example.demo.model.Lezione;
import java.time.LocalDate;
import java.util.List;

public interface LezioneService {
    Lezione saveLezione(Lezione lezione);
    Lezione getLezioneById(Long id);
    List<Lezione> getAllLezioni();
    List<Lezione> getLezioniByCorsoOrderByData(Long corsoId);
    List<Lezione> getLezioniByPeriodo(LocalDate inizio, LocalDate fine);
    List<Lezione> getUpcomingLezioniByCorso(Long corsoId);
    List<Object[]> getStatisticheLezioniPerCorso();
    void deleteLezione(Long id);
    boolean existsById(Long id);
}