package com.example.demo.repository;

import com.example.demo.model.MaterialeDidattico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MaterialeDidatticoRepository extends JpaRepository<MaterialeDidattico, Long> {
    List<MaterialeDidattico> findByLezioneId(Long lezioneId);
    List<MaterialeDidattico> findByTipoMateriale(String tipoMateriale);
    @Query("SELECT m FROM MaterialeDidattico m WHERE m.lezione.corso.id = :corsoId")
    List<MaterialeDidattico> findAllMaterialiByCorsoId(Long corsoId);
    @Query("SELECT m FROM MaterialeDidattico m WHERE m.dataCaricamento > :data")
    List<MaterialeDidattico> findRecentMateriali(LocalDate data);
}