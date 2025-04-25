package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.model.Corso;

import java.time.LocalDate;
import java.util.List;

public interface CorsoService {
    Corso saveCorso(Corso corso);
    Corso getCorsoById(Long id);
    List<Corso> getAllCorsi();
    List<Corso> getCorsiByCategoria(Categoria categoria);
    List<Corso> getCorsiByPeriodo(LocalDate dataInizio, LocalDate dataFine);
    List<Corso> getCorsiRecenti();
    List<Corso> getCorsiWithMoreThanXIscrizioni(int numeroMinimo);
    void deleteCorso(Long id);
    boolean existsById(Long id);
}