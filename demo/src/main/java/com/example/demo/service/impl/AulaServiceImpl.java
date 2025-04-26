package com.example.demo.service.impl;

import com.example.demo.model.Aula;
import com.example.demo.repository.AulaRepository;
import com.example.demo.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Override
    public List<Aula> getAllAule() {
        return aulaRepository.findAll();
    }

    @Override
    public Optional<Aula> getAulaById(Long id) {
        return aulaRepository.findById(id);
    }

    @Override
    public Aula saveAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public Aula updateAula(Long id, Aula aula) {
        aula.setIdAula(id);
        return aulaRepository.save(aula);
    }

    @Override
    public void deleteAula(Long id) {
        aulaRepository.deleteById(id);
    }

    @Override
    public List<Aula> searchByNome(String nome) {
        return aulaRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public List<Aula> searchByEdificio(String edificio) {
        return aulaRepository.findByEdificioContainingIgnoreCase(edificio);
    }

    @Override
    public List<Aula> searchByCapacita(Integer capacita) {
        return aulaRepository.findByCapacitaGreaterThanEqual(capacita);
    }

    @Override
    public List<Aula> searchByAccessibile(Boolean accessibile) {
        return aulaRepository.findByAccessibile(accessibile);
    }
}
