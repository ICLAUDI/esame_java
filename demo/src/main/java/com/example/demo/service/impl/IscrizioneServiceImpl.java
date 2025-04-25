package com.example.demo.service.impl;

import com.example.demo.model.Iscrizione;
import com.example.demo.repository.IscrizioneRepository;
import com.example.demo.service.IscrizioneService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IscrizioneServiceImpl implements IscrizioneService {

    private final IscrizioneRepository iscrizioneRepository;

    public IscrizioneServiceImpl(IscrizioneRepository iscrizioneRepository) {
        this.iscrizioneRepository = iscrizioneRepository;
    }

    @Override
    public Iscrizione saveIscrizione(Iscrizione iscrizione) {
        return iscrizioneRepository.save(iscrizione);
    }

    @Override
    public Iscrizione getIscrizioneById(Long id) {
        return iscrizioneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Iscrizione non trovata con id: " + id));
    }

    @Override
    public List<Iscrizione> getIscrizioniByStudenteIdAndCorsoId(Long studenteId, Long corsoId) {
        return iscrizioneRepository.findByStudenteIdAndCorsoId(studenteId, corsoId);
    }

    @Override
    public List<Iscrizione> getIscrizioniByDataIscrizioneBetween(LocalDate inizio, LocalDate fine) {
        return iscrizioneRepository.findByDataIscrizioneBetween(inizio, fine);
    }

    @Override
    public List<Iscrizione> getActiveIscrizioniByStudenteId(Long studenteId) {
        return iscrizioneRepository.findActiveIscrizioniByStudenteId(studenteId);
    }

    @Override
    public Long countIscrizioniByCorsoId(Long corsoId) {
        return iscrizioneRepository.countIscrizioniByCorsoId(corsoId);
    }

    @Override
    public void deleteIscrizione(Long id) {
        if (!iscrizioneRepository.existsById(id)) {
            throw new RuntimeException("Iscrizione non trovata con id: " + id);
        }
        iscrizioneRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return iscrizioneRepository.existsById(id);
    }
}
