package com.example.demo.service.impl;

import com.example.demo.model.Docente;
import com.example.demo.repository.DocenteRepository;
import com.example.demo.service.DocenteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteServiceImpl(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    @Override
    public Docente saveDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public Docente getDocenteById(Long id) {
        return docenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente non trovato con id: " + id));
    }

    @Override
    public Docente getDocenteByEmail(String email) {
        return docenteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Docente non trovato con email: " + email));
    }

    @Override
    public List<Docente> getAllDocenti() {
        return docenteRepository.findAll();
    }

    @Override
    public List<Docente> getDocentiBySpecializzazione(String specializzazione) {
        return docenteRepository.findBySpecializzazione(specializzazione);
    }

    @Override
    public List<Docente> getDocentiWithMostCorsi() {
        return docenteRepository.findDocentiWithMostCorsi();
    }

    @Override
    public List<Docente> getDocentiOrderByNumeroCorsi() {
        return docenteRepository.findAllOrderByNumeroCorsi();
    }

    @Override
    public void deleteDocente(Long id) {
        if (!docenteRepository.existsById(id)) {
            throw new RuntimeException("Docente non trovato con id: " + id);
        }
        docenteRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return docenteRepository.existsById(id);
    }
}
