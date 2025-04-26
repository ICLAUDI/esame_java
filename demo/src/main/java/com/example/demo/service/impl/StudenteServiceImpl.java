package com.example.demo.service.impl;

import com.example.demo.model.Studente;
import com.example.demo.repository.StudenteRepository;
import com.example.demo.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudenteServiceImpl implements StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;

    @Override
    public Studente createStudente(Studente studente) {
        return studenteRepository.save(studente);
    }

    @Override
    public List<Studente> getAllStudenti() {
        return studenteRepository.findAll();
    }

    @Override
    public Optional<Studente> getStudenteById(Long id) {
        return studenteRepository.findById(id);
    }

    @Override
    public List<Studente> getStudentiByNome(String nome) {
        return studenteRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public List<Studente> getStudentiByCognome(String cognome) {
        return studenteRepository.findByCognomeContainingIgnoreCase(cognome);
    }

    @Override
    public Studente getStudenteByEmail(String email) {
        return studenteRepository.findByEmail(email);
    }

    @Override
    public List<Studente> getStudentiByDataIscrizione(Date startDate, Date endDate) {
        return studenteRepository.findByDataIscrizioneBetween(startDate, endDate);
    }

    @Override
    public List<Studente> getStudentiByTitoloStudio(String titoloStudio) {
        return studenteRepository.findByTitoloStudioContainingIgnoreCase(titoloStudio);
    }

    @Override
    public Studente updateStudente(Long id, Studente studente) {
        if (studenteRepository.existsById(id)) {
            studente.setIdStudente(id);
            return studenteRepository.save(studente);
        }
        return null;
    }

    @Override
    public void deleteStudente(Long id) {
        studenteRepository.deleteById(id);
    }
}
