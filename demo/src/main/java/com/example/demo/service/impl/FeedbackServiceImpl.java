package com.example.demo.service.impl;

import com.example.demo.model.Feedback;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.service.FeedbackService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
    

    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback non trovato con id: " + id));
    }

    @Override
    public List<Feedback> getFeedbackByStudenteId(Long studenteId) {
        return feedbackRepository.findByStudenteId(studenteId);
    }
    
    @Override
public List<Feedback> getFeedbackByCorsoId(Long corsoId) {
    return feedbackRepository.findByCorsoId(corsoId);
}

    @Override
    public List<Feedback> getFeedbackByPunteggioMinimo(int punteggioMinimo) {
        return feedbackRepository.findByPunteggioGreaterThanEqual(punteggioMinimo);
    }

    @Override
    public Double getAveragePunteggioByCorsoId(Long corsoId) {
        return feedbackRepository.findAveragePunteggioByCourseId(corsoId);
    }

    @Override
    public List<Feedback> getLatestFeedbacksByCorsoId(Long corsoId, int page, int size) {
        return feedbackRepository.findLatestFeedbacksByCorsoId(corsoId, PageRequest.of(page, size));
    }

    @Override
    public void deleteFeedback(Long id) {
        if (!feedbackRepository.existsById(id)) {
            throw new RuntimeException("Feedback non trovato con id: " + id);
        }
        feedbackRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return feedbackRepository.existsById(id);
    }
}
