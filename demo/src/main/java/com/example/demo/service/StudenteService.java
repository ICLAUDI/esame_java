package com.example.demo.service;

import com.example.demo.model.Studente;
import java.time.LocalDate;
import java.util.List;

public interface StudenteService {
    Studente saveStudente(Studente studente);
    Studente getStudenteById(Long id);
    Studente getStudenteByEmail(String email);
    Studente getStudenteByNomeAndCognome(String nome, String cognome);
    List<Studente> getAllStudenti();
    List<Studente> getStudentiByDataIscrizione(LocalDate data);
    List<Studente> getStudentiByDataIscrizioneAfter(LocalDate data);
    List<Studente> getStudentiByEmailContaining(String emailDomain);
    List<Studente> getStudentiWithMoreThanXIscrizioni(int numeroMinIscr);
    void deleteStudente(Long id);
    boolean existsById(Long id);
}