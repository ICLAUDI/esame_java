package com.example.demo.repository;

import com.example.demo.model.MaterialeDidattico;
import com.example.demo.model.Corso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialeDidatticoRepository extends JpaRepository<MaterialeDidattico, Long> {
    List<MaterialeDidattico> findByCorso(Corso corso);
    List<MaterialeDidattico> findByTitoloContainingIgnoreCase(String titolo);
    List<MaterialeDidattico> findByTipo(String tipo);
}