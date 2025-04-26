package com.example.demo.service;

import com.example.demo.model.Feedback;
import com.example.demo.model.Corso;
import com.example.demo.model.Studente;

import java.util.Date;
import java.util.List;

public interface FeedbackService {
    List<Feedback> getAllFeedback();
    Feedback getFeedbackById(Long id);
    Feedback createFeedback(Feedback feedback);
    Feedback updateFeedback(Long id, Feedback feedback);
    void deleteFeedback(Long id);

    List<Feedback> getByStudente(Studente studente);
    List<Feedback> getByCorso(Corso corso);
    List<Feedback> getByValutazioneRange(int min, int max);
    List<Feedback> getByDateRange(Date start, Date end);
    Double getAverageValutazioneByCorsoId(Long corsoId);
    Feedback getByCorsoAndStudente(Corso corso, Studente studente);
}
