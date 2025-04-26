package com.example.demo.service.impl;

import com.example.demo.model.Corso;
import com.example.demo.model.Categoria;
import com.example.demo.model.Docente;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.service.CorsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CorsoServiceImpl implements CorsoService {

    @Autowired
    private CorsoRepository corsoRepository;

    @Override
    public List<Corso> getAllCorsi() {
        return corsoRepository.findAll();
    }

    @Override
    public Optional<Corso> getCorsoById(Long id) {
        return corsoRepository.findById(id);
    }

    @Override
    public Corso createCorso(Corso corso) {
        return corsoRepository.save(corso);
    }

    @Override
    public Corso updateCorso(Long id, Corso corso) {
        corso.setIdCorso(id);
        return corsoRepository.save(corso);
    }

    @Override
    public void deleteCorso(Long id) {
        corsoRepository.deleteById(id);
    }

    @Override
    public List<Corso> searchByTitolo(String titolo) {
        return corsoRepository.findByTitoloContainingIgnoreCase(titolo);
    }

    @Override
    public List<Corso> getByDocente(Docente docente) {
        return corsoRepository.findByDocente(docente);
    }

    @Override
    public List<Corso> getByCategoria(Categoria categoria) {
        return corsoRepository.findByCategoria(categoria);
    }

    @Override
    public List<Corso> getByDataInizioBetween(Date start, Date end) {
        return corsoRepository.findByDataInizioBetween(start, end);
    }

    @Override
    public List<Corso> getByDataFineBetween(Date start, Date end) {
        return corsoRepository.findByDataFineBetween(start, end);
    }

    @Override
    public List<Corso> getByPostiDisponibiliGreaterThan(Integer minPosti) {
        return corsoRepository.findByPostiDisponibiliGreaterThan(minPosti);
    }

    @Override
    public List<Corso> getCorsiFuturi() {
        return corsoRepository.findFutureCorsi();
    }

    @Override
    public List<Corso> getCorsiAttuali() {
        return corsoRepository.findCurrentCorsi();
    }
}
