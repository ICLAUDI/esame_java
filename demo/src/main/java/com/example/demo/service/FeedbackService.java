package com.example.demo.service;

import com.example.demo.model.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);
    Feedback getFeedbackById(Long id);
    List<Feedback> getFeedbackByCorsoId(Long corsoId);
    List<Feedback> getFeedbackByStudenteId(Long studenteId);
    List<Feedback> getFeedbackByPunteggioMinimo(int punteggioMinimo);
    Double getAveragePunteggioByCorsoId(Long corsoId);
    List<Feedback> getLatestFeedbacksByCorsoId(Long corsoId, int page, int size);
    void deleteFeedback(Long id);
    boolean existsById(Long id);
}
