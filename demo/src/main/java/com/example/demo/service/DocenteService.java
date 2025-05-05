package com.example.demo.service;

import com.example.demo.model.Docente;

import java.util.List;
import java.util.Optional;

public interface DocenteService {
    List<Docente> getAllDocenti();
    Optional<Docente> getDocenteById(Long id);
    Docente createDocente(Docente docente);
    Docente updateDocente(Long id, Docente docente);
    void deleteDocente(Long id);
    List<Docente> searchByNome(String nome);
    List<Docente> searchByCognome(String cognome);
    List<Docente> searchBySpecializzazione(String specializzazione);
    Optional<Docente> getByEmail(String email);
    List<Docente> searchByRuolo(String ruolo); // Aggiunta ricerca per ruolo
}
