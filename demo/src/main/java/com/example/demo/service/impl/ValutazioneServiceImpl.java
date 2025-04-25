package com.example.demo.service.impl;

import com.example.demo.model.Valutazione;
import com.example.demo.repository.ValutazioneRepository;
import com.example.demo.service.ValutazioneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValutazioneServiceImpl implements ValutazioneService {

    private final ValutazioneRepository valutazioneRepository;

    public ValutazioneServiceImpl(ValutazioneRepository valutazioneRepository) {
        this.valutazioneRepository = valutazioneRepository;
    }

    @Override
    public Valutazione saveValutazione(Valutazione valutazione) {
        return valutazioneRepository.save(valutazione);
    }

    @Override
    public Valutazione getValutazioneById(Long id) {
        return valutazioneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Valutazione non trovata con id: " + id));
    }

    @Override
    public List<Valutazione> getValutazioniByStudenteId(Long studenteId) {
        return valutazioneRepository.findByStudenteId(studenteId);
    }

    @Override
    public List<Valutazione> getValutazioniByCorsoId(Long corsoId) {
        return valutazioneRepository.findByCorsoIdOrderByDataValutazioneDesc(corsoId);
    }

    @Override
    public Double getAverageVotoByCorsoId(Long corsoId) {
        return valutazioneRepository.calculateAverageVotoByCorsoId(corsoId);
    }

    @Override
    public List<Valutazione> getValutazioniWithHighVoto(Double votoMinimo) {
        return valutazioneRepository.findValutazioniWithHighVoto(votoMinimo);
    }

    @Override
    public void deleteValutazione(Long id) {
        if (!valutazioneRepository.existsById(id)) {
            throw new RuntimeException("Valutazione non trovata con id: " + id);
        }
        valutazioneRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return valutazioneRepository.existsById(id);
    }
}
