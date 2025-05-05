package com.example.demo.service;

import com.example.demo.model.Corso;
import com.example.demo.model.Categoria;
import com.example.demo.model.Docente;

import java.util.Date;
import java.util.List;

public interface CorsoService {
    List<Corso> getAllCorsi();
    Corso getCorsoById(Long id); // 🔄 RESTITUISCE DIRETTAMENTE CORSO
    Corso createCorso(Corso corso);
    Corso updateCorso(Long id, Corso corso);
    void deleteCorso(Long id);
    List<Corso> searchByTitolo(String titolo);
    List<Corso> getByDocente(Docente docente);
    List<Corso> getByCategoria(Categoria categoria);
    List<Corso> getByDataInizioBetween(Date start, Date end);
    List<Corso> getByDataFineBetween(Date start, Date end);
    List<Corso> getByPostiDisponibiliGreaterThan(Integer minPosti);
    List<Corso> getCorsiFuturi();
    List<Corso> getCorsiAttuali();
}
