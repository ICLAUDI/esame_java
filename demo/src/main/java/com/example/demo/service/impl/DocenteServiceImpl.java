package com.example.demo.service.impl;

import com.example.demo.model.Docente;
import com.example.demo.repository.DocenteRepository;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    public List<Docente> getAllDocenti() {
        return docenteRepository.findAll();
    }

    @Override
    public Optional<Docente> getDocenteById(Long id) {
        return docenteRepository.findById(id);
    }

    @Override
    public Docente createDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public Docente updateDocente(Long id, Docente docente) {
        docente.setIdDocente(id);
        return docenteRepository.save(docente);
    }

    @Override
    public void deleteDocente(Long id) {
        docenteRepository.deleteById(id);
    }

    @Override
    public List<Docente> searchByNome(String nome) {
        return docenteRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public List<Docente> searchByCognome(String cognome) {
        return docenteRepository.findByCognomeContainingIgnoreCase(cognome);
    }

    @Override
    public List<Docente> searchBySpecializzazione(String specializzazione) {
        return docenteRepository.findBySpecializzazioneContainingIgnoreCase(specializzazione);
    }

    @Override
    public Optional<Docente> getByEmail(String email) {
        return docenteRepository.findByEmail(email);
    }
}
