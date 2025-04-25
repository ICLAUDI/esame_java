package com.example.demo.controller;

import com.example.demo.model.Studente;
import com.example.demo.service.StudenteService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController {

    private final StudenteService studenteService;

    public StudenteController(StudenteService studenteService) {
        this.studenteService = studenteService;
    }

    @PostMapping
    public Studente createStudente(@RequestBody Studente studente) {
        return studenteService.saveStudente(studente);
    }

    @GetMapping("/{id}")
    public Studente getStudenteById(@PathVariable Long id) {
        return studenteService.getStudenteById(id);
    }

    @GetMapping("/email/{email}")
    public Studente getStudenteByEmail(@PathVariable String email) {
        return studenteService.getStudenteByEmail(email);
    }

    @GetMapping("/nome/{nome}/cognome/{cognome}")
    public Studente getStudenteByNomeAndCognome(@PathVariable String nome, @PathVariable String cognome) {
        return studenteService.getStudenteByNomeAndCognome(nome, cognome);
    }

    @GetMapping
    public List<Studente> getAllStudenti() {
        return studenteService.getAllStudenti();
    }

    @GetMapping("/iscrizione/dopo/{data}")
    public List<Studente> getStudentiByDataIscrizioneAfter(@PathVariable String data) {
        LocalDate parsedDate = LocalDate.parse(data);
        return studenteService.getStudentiByDataIscrizioneAfter(parsedDate);
    }

    @GetMapping("/email-contenente/{emailDomain}")
    public List<Studente> getStudentiByEmailContaining(@PathVariable String emailDomain) {
        return studenteService.getStudentiByEmailContaining(emailDomain);
    }

    @GetMapping("/piu-di-iscrizioni/{numeroMinIscr}")
    public List<Studente> getStudentiWithMoreThanXIscrizioni(@PathVariable int numeroMinIscr) {
        return studenteService.getStudentiWithMoreThanXIscrizioni(numeroMinIscr);
    }

    @DeleteMapping("/{id}")
    public void deleteStudente(@PathVariable Long id) {
        studenteService.deleteStudente(id);
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return studenteService.existsById(id);
    }
}
