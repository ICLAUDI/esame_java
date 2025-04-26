package com.example.demo.controller;

import com.example.demo.model.Feedback;
import com.example.demo.model.Corso;
import com.example.demo.model.Studente;
import com.example.demo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> getAll() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/{id}")
    public Feedback getById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }

    @PostMapping
    public Feedback create(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }

    @PutMapping("/{id}")
    public Feedback update(@PathVariable Long id, @RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(id, feedback);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }

    @GetMapping("/studente")
    public List<Feedback> getByStudente(@RequestBody Studente studente) {
        return feedbackService.getByStudente(studente);
    }

    @GetMapping("/corso")
    public List<Feedback> getByCorso(@RequestBody Corso corso) {
        return feedbackService.getByCorso(corso);
    }

    @GetMapping("/valutazione")
    public List<Feedback> getByValutazioneRange(@RequestParam int min, @RequestParam int max) {
        return feedbackService.getByValutazioneRange(min, max);
    }

    @GetMapping("/date")
    public List<Feedback> getByDateRange(@RequestParam Date start, @RequestParam Date end) {
        return feedbackService.getByDateRange(start, end);
    }

    @GetMapping("/media/{corsoId}")
    public Double getAverageValutazione(@PathVariable Long corsoId) {
        return feedbackService.getAverageValutazioneByCorsoId(corsoId);
    }

    @PostMapping("/corso-studente")
    public Feedback getByCorsoAndStudente(@RequestBody Corso corso, @RequestBody Studente studente) {
        return feedbackService.getByCorsoAndStudente(corso, studente);
    }
}
