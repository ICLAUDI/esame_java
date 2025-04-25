package com.example.demo.repository;

import com.example.demo.model.Categoria;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    Optional<Categoria> findByNome(String nome);
    @Query("SELECT c FROM Categoria c WHERE SIZE(c.corsi) > 0")
    List<Categoria> findCategorieWithCorsi();
    @Query("SELECT c.nome, COUNT(co) FROM Categoria c JOIN c.corsi co GROUP BY c.nome ORDER BY COUNT(co) DESC")
    List<Object[]> countCorsiPerCategoria();
    List<Categoria> findByDescrizioneContaining(String keyword);
}