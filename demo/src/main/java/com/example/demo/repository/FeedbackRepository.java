package com.example.demo.repository;

import com.example.demo.model.Feedback;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByPunteggioGreaterThanEqual(int punteggioMinimo);
    List<Feedback> findByStudenteId(Long studenteId);
    List<Feedback> findByCorsoId(Long corsoId);
    @Query("SELECT AVG(f.punteggio) FROM Feedback f WHERE f.corso.id = :corsoId")
    Double findAveragePunteggioByCourseId(Long corsoId);
    @Query("SELECT f FROM Feedback f WHERE f.corso.id = :corsoId ORDER BY f.dataCreazione DESC")
    List<Feedback> findLatestFeedbacksByCorsoId(Long corsoId, Pageable pageable);
}