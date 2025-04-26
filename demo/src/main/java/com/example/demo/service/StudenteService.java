package com.example.demo.service;

import com.example.demo.model.Studente;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface StudenteService {
    Studente createStudente(Studente studente);
    List<Studente> getAllStudenti();
    Optional<Studente> getStudenteById(Long id);
    List<Studente> getStudentiByNome(String nome);
    List<Studente> getStudentiByCognome(String cognome);
    Studente getStudenteByEmail(String email);
    List<Studente> getStudentiByDataIscrizione(Date startDate, Date endDate);
    List<Studente> getStudentiByTitoloStudio(String titoloStudio);
    Studente updateStudente(Long id, Studente studente);
    void deleteStudente(Long id);
}
