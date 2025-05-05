package com.example.demo.controller;

import com.example.demo.Dto.DocenteDTO;
import com.example.demo.Mapper.DocenteMapper;
import com.example.demo.model.Docente;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/docenti")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping
    public List<DocenteDTO> getAll() {
        return docenteService.getAllDocenti().stream()
                .map(DocenteMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<DocenteDTO> getById(@PathVariable Long id) {
        Optional<Docente> docente = docenteService.getDocenteById(id);
        return docente.map(DocenteMapper::toDto);
    }

    @PostMapping
    public DocenteDTO create(@RequestBody DocenteDTO docenteDTO) {
        Docente docente = DocenteMapper.toEntity(docenteDTO);
        docente = docenteService.createDocente(docente);
        return DocenteMapper.toDto(docente);
    }

    @PutMapping("/{id}")
    public DocenteDTO update(@PathVariable Long id, @RequestBody DocenteDTO docenteDTO) {
        Docente docente = DocenteMapper.toEntity(docenteDTO);
        docente = docenteService.updateDocente(id, docente);
        return DocenteMapper.toDto(docente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        docenteService.deleteDocente(id);
    }

    @GetMapping("/search/nome")
    public List<DocenteDTO> searchByNome(@RequestParam String nome) {
        return docenteService.searchByNome(nome).stream()
                .map(DocenteMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/search/cognome")
    public List<DocenteDTO> searchByCognome(@RequestParam String cognome) {
        return docenteService.searchByCognome(cognome).stream()
                .map(DocenteMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/search/specializzazione")
    public List<DocenteDTO> searchBySpecializzazione(@RequestParam String specializzazione) {
        return docenteService.searchBySpecializzazione(specializzazione).stream()
                .map(DocenteMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/search/email")
    public Optional<DocenteDTO> getByEmail(@RequestParam String email) {
        Optional<Docente> docente = docenteService.getByEmail(email);
        return docente.map(DocenteMapper::toDto);
    }

    @GetMapping("/search/ruolo")
    public List<DocenteDTO> searchByRuolo(@RequestParam String ruolo) {
        return docenteService.searchByRuolo(ruolo).stream()
                .map(DocenteMapper::toDto)
                .collect(Collectors.toList());
    }
}
