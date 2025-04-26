package com.example.demo.service.impl;

import com.example.demo.model.Valutazione;
import com.example.demo.model.Iscrizione;
import com.example.demo.model.Docente;
import com.example.demo.repository.ValutazioneRepository;
import com.example.demo.service.ValutazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ValutazioneServiceImpl implements ValutazioneService {

    @Autowired
    private ValutazioneRepository valutazioneRepository;

    @Override
    public Valutazione createValutazione(Valutazione valutazione) {
        return valutazioneRepository.save(valutazione);
    }

    @Override
    public List<Valutazione> getAllValutazioni() {
        return valutazioneRepository.findAll();
    }

    @Override
    public Optional<Valutazione> getValutazioneById(Long id) {
        return valutazioneRepository.findById(id);
    }

    @Override
    public List<Valutazione> getValutazioniByIscrizione(Iscrizione iscrizione) {
        return valutazioneRepository.findByIscrizione(iscrizione);
    }

    @Override
    public List<Valutazione> getValutazioniByDocente(Docente docente) {
        return valutazioneRepository.findByDocente(docente);
    }

    @Override
    public List<Valutazione> getValutazioniByVotoRange(Integer minVoto, Integer maxVoto) {
        return valutazioneRepository.findByVotoBetween(minVoto, maxVoto);
    }

    @Override
    public List<Valutazione> getValutazioniByDataValutazione(Date startDate, Date endDate) {
        return valutazioneRepository.findByDataValutazioneBetween(startDate, endDate);
    }

    @Override
    public List<Valutazione> getValutazioniByTipoValutazione(String tipoValutazione) {
        return valutazioneRepository.findByTipoValutazione(tipoValutazione);
    }

    @Override
    public Double getAverageVotoByIscrizioneId(Long iscrizioneId) {
        return valutazioneRepository.avgVotoByIscrizioneId(iscrizioneId);
    }

    @Override
    public Double getAverageVotoByCorsoId(Long corsoId) {
        return valutazioneRepository.avgVotoByCorsoId(corsoId);
    }

    @Override
    public Valutazione updateValutazione(Long id, Valutazione valutazione) {
        if (valutazioneRepository.existsById(id)) {
            valutazione.setIdValutazione(id);
            return valutazioneRepository.save(valutazione);
        }
        return null;
    }

    @Override
    public void deleteValutazione(Long id) {
        valutazioneRepository.deleteById(id);
    }
}
