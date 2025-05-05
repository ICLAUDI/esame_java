package com.example.demo.controller;

import com.example.demo.Dto.StudenteDTO;
import com.example.demo.Mapper.StudenteMapper;
import com.example.demo.model.Studente;
import com.example.demo.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/studente")
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    // Crea uno studente
    @PostMapping
    public ResponseEntity<StudenteDTO> createStudente(@RequestBody Studente studente) {
        Studente createdStudente = studenteService.createStudente(studente);
        return ResponseEntity.ok(StudenteMapper.toDTO(createdStudente));
    }

    // Ottieni tutti gli studenti
    @GetMapping
    public List<StudenteDTO> getAllStudenti() {
        List<Studente> studenti = studenteService.getAllStudenti();
        return studenti.stream()
                .map(StudenteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Ottieni studente per id
    @GetMapping("/{id}")
    public ResponseEntity<StudenteDTO> getStudenteById(@PathVariable Long id) {
        Optional<Studente> studente = studenteService.getStudenteById(id);
        return studente.map(s -> ResponseEntity.ok(StudenteMapper.toDTO(s)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ricerca studenti per nome
    @GetMapping("/nome/{nome}")
    public List<StudenteDTO> getStudentiByNome(@PathVariable String nome) {
        List<Studente> studenti = studenteService.getStudentiByNome(nome);
        return studenti.stream()
                .map(StudenteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Ricerca studenti per cognome
    @GetMapping("/cognome/{cognome}")
    public List<StudenteDTO> getStudentiByCognome(@PathVariable String cognome) {
        List<Studente> studenti = studenteService.getStudentiByCognome(cognome);
        return studenti.stream()
                .map(StudenteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Ricerca studenti per email
    @GetMapping("/email/{email}")
    public ResponseEntity<StudenteDTO> getStudenteByEmail(@PathVariable String email) {
        Studente studente = studenteService.getStudenteByEmail(email);
        return studente != null ? ResponseEntity.ok(StudenteMapper.toDTO(studente)) : ResponseEntity.notFound().build();
    }

    // Ricerca studenti per data iscrizione
    @GetMapping("/data-iscrizione")
    public List<StudenteDTO> getStudentiByDataIscrizione(@RequestParam Date startDate, @RequestParam Date endDate) {
        List<Studente> studenti = studenteService.getStudentiByDataIscrizione(startDate, endDate);
        return studenti.stream()
                .map(StudenteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Ricerca studenti per titolo di studio
    @GetMapping("/titolo-studio")
    public List<StudenteDTO> getStudentiByTitoloStudio(@RequestParam String titoloStudio) {
        List<Studente> studenti = studenteService.getStudentiByTitoloStudio(titoloStudio);
        return studenti.stream()
                .map(StudenteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Aggiornamento studente
    @PutMapping("/{id}")
    public ResponseEntity<StudenteDTO> updateStudente(@PathVariable Long id, @RequestBody Studente studente) {
        Studente updatedStudente = studenteService.updateStudente(id, studente);
        return updatedStudente != null ? ResponseEntity.ok(StudenteMapper.toDTO(updatedStudente)) : ResponseEntity.notFound().build();
    }

    // Elimina studente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudente(@PathVariable Long id) {
        studenteService.deleteStudente(id);
        return ResponseEntity.noContent().build();
    }
}
