package com.example.demo.service.impl;

import com.example.demo.model.Studente;
import com.example.demo.repository.StudenteRepository;
import com.example.demo.service.StudenteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudenteServiceImpl implements StudenteService {

    private final StudenteRepository studenteRepository;

    public StudenteServiceImpl(StudenteRepository studenteRepository) {
        this.studenteRepository = studenteRepository;
    }

    @Override
    public Studente saveStudente(Studente studente) {
        return studenteRepository.save(studente);
    }

    @Override
    public Studente getStudenteById(Long id) {
        return studenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Studente non trovato con id: " + id));
    }

    @Override
    public Studente getStudenteByEmail(String email) {
        Studente studente = studenteRepository.findByEmail(email);
        if (studente == null) {
            throw new RuntimeException("Studente non trovato con email: " + email);
        }
        return studente;
    }

    @Override
    public Studente getStudenteByNomeAndCognome(String nome, String cognome) {
        Studente studente = studenteRepository.findByNomeAndCognome(nome, cognome);
        if (studente == null) {
            throw new RuntimeException("Studente non trovato con nome e cognome: " + nome + " " + cognome);
        }
        return studente;
    }

    @Override
    public List<Studente> getAllStudenti() {
        return studenteRepository.findAll();
    }

    @Override
    public List<Studente> getStudentiByDataIscrizione(LocalDate data) {
        return studenteRepository.findByDataIscrizioneAfter(data.minusDays(1))
                .stream()
                .filter(s -> s.getDataIscrizione().equals(data))
                .toList();
    }

    @Override
    public List<Studente> getStudentiByDataIscrizioneAfter(LocalDate data) {
        return studenteRepository.findByDataIscrizioneAfter(data);
    }

    @Override
    public List<Studente> getStudentiByEmailContaining(String emailDomain) {
        return studenteRepository.findByEmailContaining(emailDomain);
    }

    @Override
    public List<Studente> getStudentiWithMoreThanXIscrizioni(int numeroMinIscr) {
        return studenteRepository.findStudentiWithMoreThanXIscrizioni(numeroMinIscr);
    }

    @Override
    public void deleteStudente(Long id) {
        studenteRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return studenteRepository.existsById(id);
    }
}
