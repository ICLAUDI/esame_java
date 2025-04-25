package com.example.demo.repository;

import com.example.demo.model.Iscrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IscrizioneRepository extends JpaRepository<Iscrizione, Long> {
    List<Iscrizione> findByStudenteIdAndCorsoId(Long studenteId, Long corsoId);
    List<Iscrizione> findByDataIscrizioneBetween(LocalDate inizio, LocalDate fine);
    @Query("SELECT i FROM Iscrizione i WHERE i.studente.id = :studenteId AND i.corso.dataFine > CURRENT_DATE")
    List<Iscrizione> findActiveIscrizioniByStudenteId(Long studenteId);
    @Query("SELECT COUNT(i) FROM Iscrizione i WHERE i.corso.id = :corsoId")
    Long countIscrizioniByCorsoId(Long corsoId);
}