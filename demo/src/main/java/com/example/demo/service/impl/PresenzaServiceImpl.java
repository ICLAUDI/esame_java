package com.example.demo.service.impl;

import com.example.demo.model.Presenza;
import com.example.demo.model.Lezione;
import com.example.demo.model.Iscrizione;
import com.example.demo.repository.PresenzaRepository;
import com.example.demo.service.PresenzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresenzaServiceImpl implements PresenzaService {

    @Autowired
    private PresenzaRepository presenzaRepository;

    @Override
    public Presenza createPresenza(Presenza presenza) {
        return presenzaRepository.save(presenza);
    }

    @Override
    public List<Presenza> getAllPresenze() {
        return presenzaRepository.findAll();
    }

    @Override
    public Optional<Presenza> getPresenzaById(Long id) {
        return presenzaRepository.findById(id);
    }

    @Override
    public List<Presenza> getPresenzeByLezione(Lezione lezione) {
        return presenzaRepository.findByLezione(lezione);
    }

    @Override
    public List<Presenza> getPresenzeByIscrizione(Iscrizione iscrizione) {
        return presenzaRepository.findByIscrizione(iscrizione);
    }

    @Override
    public List<Presenza> getPresenzeByPresenza(Boolean presente) {
        return presenzaRepository.findByPresente(presente);
    }

    @Override
    public Presenza updatePresenza(Long id, Presenza presenza) {
        if (presenzaRepository.existsById(id)) {
            presenza.setIdPresenza(id);
            return presenzaRepository.save(presenza);
        }
        return null;
    }

    @Override
    public void deletePresenza(Long id) {
        presenzaRepository.deleteById(id);
    }

    @Override
    public Presenza getPresenzaByLezioneAndIscrizione(Lezione lezione, Iscrizione iscrizione) {
        return presenzaRepository.findByLezioneAndIscrizione(lezione, iscrizione);
    }

    @Override
    public Integer countPresenzeByIscrizioneId(Long iscrizioneId) {
        return presenzaRepository.countPresencesByIscrizioneId(iscrizioneId);
    }

    @Override
    public Integer countPresenzeByLezioneId(Long lezioneId) {
        return presenzaRepository.countPresencesByLezioneId(lezioneId);
    }
}
