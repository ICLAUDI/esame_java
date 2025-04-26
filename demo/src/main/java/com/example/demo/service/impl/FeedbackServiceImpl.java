package com.example.demo.service.impl;

import com.example.demo.model.Feedback;
import com.example.demo.model.Corso;
import com.example.demo.model.Studente;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback updateFeedback(Long id, Feedback feedback) {
        feedback.setIdFeedback(id);
        return feedbackRepository.save(feedback);
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public List<Feedback> getByStudente(Studente studente) {
        return feedbackRepository.findByStudente(studente);
    }

    @Override
    public List<Feedback> getByCorso(Corso corso) {
        return feedbackRepository.findByCorso(corso);
    }

    @Override
    public List<Feedback> getByValutazioneRange(int min, int max) {
        return feedbackRepository.findByValutazioneBetween(min, max);
    }

    @Override
    public List<Feedback> getByDateRange(Date start, Date end) {
        return feedbackRepository.findByDataFeedbackBetween(start, end);
    }

    @Override
    public Double getAverageValutazioneByCorsoId(Long corsoId) {
        return feedbackRepository.avgValutazioneByCorsoId(corsoId);
    }

    @Override
    public Feedback getByCorsoAndStudente(Corso corso, Studente studente) {
        return feedbackRepository.findByCorsoAndStudente(corso, studente);
    }
}
