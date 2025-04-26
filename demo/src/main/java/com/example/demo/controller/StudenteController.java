package com.example.demo.controller;

import com.example.demo.model.Studente;
import com.example.demo.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studente")
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    // Crea un nuovo studente
    @PostMapping
    public ResponseEntity<Studente> createStudente(@RequestBody Studente studente) {
        Studente createdStudente = studenteService.createStudente(studente);
        return ResponseEntity.ok(createdStudente);
    }

    // Ottieni tutti gli studenti
    @GetMapping
    public List<Studente> getAllStudenti() {
        return studenteService.getAllStudenti();
    }

    // Ottieni uno studente per ID
    @GetMapping("/{id}")
    public ResponseEntity<Studente> getStudenteById(@PathVariable Long id) {
        Optional<Studente> studente = studenteService.getStudenteById(id);
        return studente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ottieni studenti per nome
    @GetMapping("/nome/{nome}")
    public List<Studente> getStudentiByNome(@PathVariable String nome) {
        return studenteService.getStudentiByNome(nome);
    }

    // Ottieni studenti per cognome
    @GetMapping("/cognome/{cognome}")
    public List<Studente> getStudentiByCognome(@PathVariable String cognome) {
        return studenteService.getStudentiByCognome(cognome);
    }

    // Ottieni uno studente per email
    @GetMapping("/email/{email}")
    public ResponseEntity<Studente> getStudenteByEmail(@PathVariable String email) {
        Studente studente = studenteService.getStudenteByEmail(email);
        return studente != null ? ResponseEntity.ok(studente) : ResponseEntity.notFound().build();
    }

    // Ottieni studenti per data iscrizione
    @GetMapping("/data-iscrizione")
    public List<Studente> getStudentiByDataIscrizione(@RequestParam Date startDate, @RequestParam Date endDate) {
        return studenteService.getStudentiByDataIscrizione(startDate, endDate);
    }

    // Ottieni studenti per titolo di studio
    @GetMapping("/titolo-studio")
    public List<Studente> getStudentiByTitoloStudio(@RequestParam String titoloStudio) {
        return studenteService.getStudentiByTitoloStudio(titoloStudio);
    }

    // Aggiorna uno studente esistente
    @PutMapping("/{id}")
    public ResponseEntity<Studente> updateStudente(@PathVariable Long id, @RequestBody Studente studente) {
        Studente updatedStudente = studenteService.updateStudente(id, studente);
        return updatedStudente != null ? ResponseEntity.ok(updatedStudente) : ResponseEntity.notFound().build();
    }

    // Elimina uno studente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudente(@PathVariable Long id) {
        studenteService.deleteStudente(id);
        return ResponseEntity.noContent().build();
    }
}
