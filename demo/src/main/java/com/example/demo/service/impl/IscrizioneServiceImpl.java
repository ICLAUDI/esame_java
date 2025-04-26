package com.example.demo.service.impl;

import com.example.demo.model.Iscrizione;
import com.example.demo.model.Corso;
import com.example.demo.model.Studente;
import com.example.demo.repository.IscrizioneRepository;
import com.example.demo.service.IscrizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IscrizioneServiceImpl implements IscrizioneService {

    @Autowired
    private IscrizioneRepository iscrizioneRepository;

    @Override
    public List<Iscrizione> getAllIscrizioni() {
        return iscrizioneRepository.findAll();
    }

    @Override
    public Iscrizione getIscrizioneById(Long id) {
        return iscrizioneRepository.findById(id).orElse(null);
    }

    @Override
    public Iscrizione createIscrizione(Iscrizione iscrizione) {
        return iscrizioneRepository.save(iscrizione);
    }

    @Override
    public Iscrizione updateIscrizione(Long id, Iscrizione iscrizione) {
        iscrizione.setIdIscrizione(id);
        return iscrizioneRepository.save(iscrizione);
    }

    @Override
    public void deleteIscrizione(Long id) {
        iscrizioneRepository.deleteById(id);
    }

    @Override
    public List<Iscrizione> getByStudente(Studente studente) {
        return iscrizioneRepository.findByStudente(studente);
    }

    @Override
    public List<Iscrizione> getByCorso(Corso corso) {
        return iscrizioneRepository.findByCorso(corso);
    }

    @Override
    public List<Iscrizione> getByDateRange(Date start, Date end) {
        return iscrizioneRepository.findByDataIscrizioneBetween(start, end);
    }

    @Override
    public List<Iscrizione> getByStato(String stato) {
        return iscrizioneRepository.findByStato(stato);
    }

    @Override
    public List<Iscrizione> getByCompletato(Boolean completato) {
        return iscrizioneRepository.findByCompletato(completato);
    }

    @Override
    public Integer countByCorsoId(Long corsoId) {
        return iscrizioneRepository.countByCorsoId(corsoId);
    }

    @Override
    public List<Iscrizione> getByStudenteAndCorso(Studente studente, Corso corso) {
        return iscrizioneRepository.findByStudenteAndCorso(studente, corso);
    }
}
