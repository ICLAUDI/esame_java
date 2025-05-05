package com.example.demo.controller;

import com.example.demo.Dto.FeedbackDTO;
import com.example.demo.Mapper.FeedbackMapper;
import com.example.demo.model.Corso;
import com.example.demo.model.Feedback;
import com.example.demo.model.Studente;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.repository.StudenteRepository;
import com.example.demo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private StudenteRepository studenteRepository;

    @Autowired
    private CorsoRepository corsoRepository;

    @GetMapping
    public List<FeedbackDTO> getAll() {
        return feedbackService.getAllFeedback().stream()
                .map(FeedbackMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FeedbackDTO getById(@PathVariable Long id) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        return FeedbackMapper.toDTO(feedback);
    }

    @PostMapping
    public FeedbackDTO create(@RequestBody FeedbackDTO dto) {
        Studente studente = studenteRepository.findById(dto.getIdStudente()).orElseThrow();
        Corso corso = corsoRepository.findById(dto.getIdCorso()).orElseThrow();
        Feedback feedback = FeedbackMapper.toEntity(dto, studente, corso);
        return FeedbackMapper.toDTO(feedbackService.createFeedback(feedback));
    }

    @PutMapping("/{id}")
    public FeedbackDTO update(@PathVariable Long id, @RequestBody FeedbackDTO dto) {
        Studente studente = studenteRepository.findById(dto.getIdStudente()).orElseThrow();
        Corso corso = corsoRepository.findById(dto.getIdCorso()).orElseThrow();
        Feedback feedback = FeedbackMapper.toEntity(dto, studente, corso);
        return FeedbackMapper.toDTO(feedbackService.updateFeedback(id, feedback));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }

    @GetMapping("/valutazione")
    public List<FeedbackDTO> getByValutazioneRange(@RequestParam int min, @RequestParam int max) {
        return feedbackService.getByValutazioneRange(min, max).stream()
                .map(FeedbackMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/date")
    public List<FeedbackDTO> getByDateRange(@RequestParam Date start, @RequestParam Date end) {
        return feedbackService.getByDateRange(start, end).stream()
                .map(FeedbackMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/media/{corsoId}")
    public Double getAverageValutazione(@PathVariable Long corsoId) {
        return feedbackService.getAverageValutazioneByCorsoId(corsoId);
    }

    @PostMapping("/corso-studente")
    public FeedbackDTO getByCorsoAndStudente(@RequestParam Long idCorso, @RequestParam Long idStudente) {
        Corso corso = corsoRepository.findById(idCorso).orElseThrow();
        Studente studente = studenteRepository.findById(idStudente).orElseThrow();
        Feedback feedback = feedbackService.getByCorsoAndStudente(corso, studente);
        return FeedbackMapper.toDTO(feedback);
    }
}
