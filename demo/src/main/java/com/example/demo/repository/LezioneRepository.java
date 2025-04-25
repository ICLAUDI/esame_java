package com.example.demo.repository;

import com.example.demo.model.Lezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LezioneRepository extends JpaRepository<Lezione, Long> {
    List<Lezione> findByCorsoIdOrderByDataAsc(Long corsoId);
    List<Lezione> findByDataBetween(LocalDate inizio, LocalDate fine);
    @Query("SELECT l FROM Lezione l WHERE l.data >= CURRENT_DATE AND l.corso.id = :corsoId ORDER BY l.data ASC")
    List<Lezione> findUpcomingLezioniByCorsoId(Long corsoId);
    @Query("SELECT l.corso.id, COUNT(l) FROM Lezione l GROUP BY l.corso.id")
    List<Object[]> countLezioniPerCorso();
}