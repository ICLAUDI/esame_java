package com.example.demo.controller;

import com.example.demo.model.Lezione;
import com.example.demo.service.LezioneService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/lezioni")
public class LezioneController {

    private final LezioneService lezioneService;

    public LezioneController(LezioneService lezioneService) {
        this.lezioneService = lezioneService;
    }

    @PostMapping
    public Lezione createLezione(@RequestBody Lezione lezione) {
        return lezioneService.saveLezione(lezione);
    }

    @GetMapping("/{id}")
    public Lezione getLezioneById(@PathVariable Long id) {
        return lezioneService.getLezioneById(id);
    }

    @GetMapping("/corso/{corsoId}")
    public List<Lezione> getLezioniByCorso(@PathVariable Long corsoId) {
        return lezioneService.getLezioniByCorsoOrderByData(corsoId);
    }

    @GetMapping("/periodo")
    public List<Lezione> getLezioniByPeriodo(@RequestParam LocalDate inizio, @RequestParam LocalDate fine) {
        return lezioneService.getLezioniByPeriodo(inizio, fine);
    }

    @GetMapping("/corso/{corsoId}/future")
    public List<Lezione> getUpcomingLezioniByCorso(@PathVariable Long corsoId) {
        return lezioneService.getUpcomingLezioniByCorso(corsoId);
    }

    @GetMapping("/statistiche")
    public List<Object[]> getStatisticheLezioniPerCorso() {
        return lezioneService.getStatisticheLezioniPerCorso();
    }

    @DeleteMapping("/{id}")
    public void deleteLezione(@PathVariable Long id) {
        lezioneService.deleteLezione(id);
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return lezioneService.existsById(id);
    }
}
