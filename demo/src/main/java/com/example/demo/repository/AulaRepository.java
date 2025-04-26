package com.example.demo.repository;

import com.example.demo.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {
    List<Aula> findByNomeContainingIgnoreCase(String nome);
    List<Aula> findByEdificioContainingIgnoreCase(String edificio);
    List<Aula> findByCapacitaGreaterThanEqual(Integer capacita);
    List<Aula> findByAccessibile(Boolean accessibile);
}