package com.example.demo.service.impl;

import com.example.demo.model.Lezione;
import com.example.demo.model.Corso;
import com.example.demo.model.Docente;
import com.example.demo.model.Aula;
import com.example.demo.repository.LezioneRepository;
import com.example.demo.service.LezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LezioneServiceImpl implements LezioneService {

    @Autowired
    private LezioneRepository lezioneRepository;

    @Override
    public List<Lezione> getAllLezioni() {
        return lezioneRepository.findAll();
    }

    @Override
    public Lezione getLezioneById(Long id) {
        return lezioneRepository.findById(id).orElse(null);
    }

    @Override
    public Lezione createLezione(Lezione lezione) {
        return lezioneRepository.save(lezione);
    }

    @Override
    public Lezione updateLezione(Long id, Lezione lezione) {
        lezione.setIdLezione(id);
        return lezioneRepository.save(lezione);
    }

    @Override
    public void deleteLezione(Long id) {
        lezioneRepository.deleteById(id);
    }

    @Override
    public List<Lezione> getByCorso(Corso corso) {
        return lezioneRepository.findByCorso(corso);
    }

    @Override
    public List<Lezione> getByDocente(Docente docente) {
        return lezioneRepository.findByDocente(docente);
    }

    @Override
    public List<Lezione> getByAula(Aula aula) {
        return lezioneRepository.findByAula(aula);
    }

    @Override
    public List<Lezione> getByData(Date data) {
        return lezioneRepository.findByData(data);
    }

    @Override
    public List<Lezione> getByDataBetween(Date startDate, Date endDate) {
        return lezioneRepository.findByDataBetween(startDate, endDate);
    }

    @Override
    public List<Lezione> getByArgomento(String argomento) {
        return lezioneRepository.findByArgomentoContainingIgnoreCase(argomento);
    }

    @Override
    public List<Lezione> getByAulaAndDataAndTimeOverlap(Aula aula, Date data, String oraFine, String oraInizio) {
        return lezioneRepository.findByAulaAndDataAndOraInizioLessThanEqualAndOraFineGreaterThanEqual(
                aula, data, oraFine, oraInizio);
    }
}
