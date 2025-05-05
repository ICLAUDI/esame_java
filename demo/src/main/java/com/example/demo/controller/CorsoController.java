package com.example.demo.controller;

import com.example.demo.Dto.CorsoDTO;
import com.example.demo.Mapper.CorsoMapper;
import com.example.demo.model.Corso;
import com.example.demo.service.CorsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/corsi")
public class CorsoController {

    @Autowired
    private CorsoService corsoService;

    @GetMapping
    public List<CorsoDTO> getAll() {
        return corsoService.getAllCorsi().stream()
                .map(CorsoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CorsoDTO getById(@PathVariable Long id) {
        Corso corso = corsoService.getCorsoById(id); // 🔄 niente Optional
        return CorsoMapper.toDTO(corso);
    }

    @PostMapping
    public CorsoDTO create(@RequestBody CorsoDTO corsoDTO) {
        Corso corso = CorsoMapper.toEntity(corsoDTO);
        corso = corsoService.createCorso(corso);
        return CorsoMapper.toDTO(corso);
    }

    @PutMapping("/{id}")
    public CorsoDTO update(@PathVariable Long id, @RequestBody CorsoDTO corsoDTO) {
        Corso corso = CorsoMapper.toEntity(corsoDTO);
        corso.setIdCorso(id);
        corso = corsoService.updateCorso(id, corso);
        return CorsoMapper.toDTO(corso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        corsoService.deleteCorso(id);
    }

    @GetMapping("/search/titolo")
    public List<CorsoDTO> searchByTitolo(@RequestParam String titolo) {
        return corsoService.searchByTitolo(titolo).stream()
                .map(CorsoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/search/futuri")
    public List<CorsoDTO> getCorsiFuturi() {
        return corsoService.getCorsiFuturi().stream()
                .map(CorsoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/search/attuali")
    public List<CorsoDTO> getCorsiAttuali() {
        return corsoService.getCorsiAttuali().stream()
                .map(CorsoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/search/date-inizio")
    public List<CorsoDTO> getByDataInizioBetween(@RequestParam Date start, @RequestParam Date end) {
        return corsoService.getByDataInizioBetween(start, end).stream()
                .map(CorsoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/search/date-fine")
    public List<CorsoDTO> getByDataFineBetween(@RequestParam Date start, @RequestParam Date end) {
        return corsoService.getByDataFineBetween(start, end).stream()
                .map(CorsoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/search/posti")
    public List<CorsoDTO> getByPostiDisponibiliGreaterThan(@RequestParam Integer minPosti) {
        return corsoService.getByPostiDisponibiliGreaterThan(minPosti).stream()
                .map(CorsoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
