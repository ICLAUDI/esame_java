package com.example.demo.service;

import com.example.demo.model.Docente;

import java.util.List;

public interface DocenteService {
    Docente saveDocente(Docente docente);
    Docente getDocenteById(Long id);
    Docente getDocenteByEmail(String email);
    List<Docente> getAllDocenti();
    List<Docente> getDocentiBySpecializzazione(String specializzazione);
    List<Docente> getDocentiWithMostCorsi();
    List<Docente> getDocentiOrderByNumeroCorsi();
    void deleteDocente(Long id);
    boolean existsById(Long id);
}
