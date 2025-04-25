package com.example.demo.service.impl;

import com.example.demo.model.Lezione;
import com.example.demo.repository.LezioneRepository;
import com.example.demo.service.LezioneService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LezioneServiceImpl implements LezioneService {

    private final LezioneRepository lezioneRepository;

    public LezioneServiceImpl(LezioneRepository lezioneRepository) {
        this.lezioneRepository = lezioneRepository;
    }

    @Override
    public Lezione saveLezione(Lezione lezione) {
        return lezioneRepository.save(lezione);
    }

    @Override
    public Lezione getLezioneById(Long id) {
        return lezioneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lezione non trovata con id: " + id));
    }

    @Override
    public List<Lezione> getAllLezioni() {
        return lezioneRepository.findAll();
    }

    @Override
    public List<Lezione> getLezioniByCorsoOrderByData(Long corsoId) {
        return lezioneRepository.findByCorsoIdOrderByDataAsc(corsoId);
    }

    @Override
    public List<Lezione> getLezioniByPeriodo(LocalDate inizio, LocalDate fine) {
        return lezioneRepository.findByDataBetween(inizio, fine);
    }

    @Override
    public List<Lezione> getUpcomingLezioniByCorso(Long corsoId) {
        return lezioneRepository.findUpcomingLezioniByCorsoId(corsoId);
    }

    @Override
    public List<Object[]> getStatisticheLezioniPerCorso() {
        return lezioneRepository.countLezioniPerCorso();
    }

    @Override
    public void deleteLezione(Long id) {
        if (!lezioneRepository.existsById(id)) {
            throw new RuntimeException("Impossibile eliminare, lezione non trovata con id: " + id);
        }
        lezioneRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return lezioneRepository.existsById(id);
    }
}