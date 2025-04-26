package com.example.demo.service;

import com.example.demo.model.Aula;

import java.util.List;
import java.util.Optional;

public interface AulaService {
    List<Aula> getAllAule();
    Optional<Aula> getAulaById(Long id);
    Aula saveAula(Aula aula);
    Aula updateAula(Long id, Aula aula);
    void deleteAula(Long id);
    List<Aula> searchByNome(String nome);
    List<Aula> searchByEdificio(String edificio);
    List<Aula> searchByCapacita(Integer capacita);
    List<Aula> searchByAccessibile(Boolean accessibile);
}
