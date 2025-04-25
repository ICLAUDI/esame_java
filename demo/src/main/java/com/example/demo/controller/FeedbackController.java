package com.example.demo.controller;

import com.example.demo.model.Feedback;
import com.example.demo.service.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @GetMapping("/{id}")
    public Feedback getFeedback(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }

    @GetMapping("/studente/{studenteId}")
    public List<Feedback> getFeedbackByStudente(@PathVariable Long studenteId) {
        return feedbackService.getFeedbackByStudenteId(studenteId);
    }

    @GetMapping("/corso/{corsoId}")
    public List<Feedback> getFeedbackByCorso(@PathVariable Long corsoId) {
        return feedbackService.getFeedbackByCorsoId(corsoId);
    }

    @GetMapping("/corso/{corsoId}/media")
    public Double getAverageFeedback(@PathVariable Long corsoId) {
        return feedbackService.getAveragePunteggioByCorsoId(corsoId);
    }

    @GetMapping("/corso/{corsoId}/ultimi")
public List<Feedback> getLatestFeedbacks(
        @PathVariable Long corsoId,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
    return feedbackService.getLatestFeedbacksByCorsoId(corsoId, page, size);
}


    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }
}
