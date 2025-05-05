package com.example.demo.controller;

import com.example.demo.Dto.PresenzaDTO;
import com.example.demo.Mapper.PresenzaMapper;
import com.example.demo.model.Presenza;
import com.example.demo.model.Lezione;
import com.example.demo.model.Iscrizione;
import com.example.demo.service.PresenzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/presenze")
public class PresenzaController {

    @Autowired
    private PresenzaService presenzaService;

    @PostMapping
    public ResponseEntity<PresenzaDTO> createPresenza(@RequestBody PresenzaDTO presenzaDTO) {
        Presenza presenza = PresenzaMapper.toEntity(presenzaDTO);
        Presenza created = presenzaService.createPresenza(presenza);
        return ResponseEntity.ok(PresenzaMapper.toDTO(created));
    }

    @GetMapping
    public List<PresenzaDTO> getAllPresenze() {
        return presenzaService.getAllPresenze().stream()
                .map(PresenzaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PresenzaDTO> getPresenzaById(@PathVariable Long id) {
        return presenzaService.getPresenzaById(id)
                .map(p -> ResponseEntity.ok(PresenzaMapper.toDTO(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/lezione/{lezioneId}")
    public List<PresenzaDTO> getPresenzeByLezione(@PathVariable Long lezioneId) {
        Lezione lezione = new Lezione();
        lezione.setIdLezione(lezioneId);
        return presenzaService.getPresenzeByLezione(lezione).stream()
                .map(PresenzaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/iscrizione/{iscrizioneId}")
    public List<PresenzaDTO> getPresenzeByIscrizione(@PathVariable Long iscrizioneId) {
        Iscrizione iscrizione = new Iscrizione();
        iscrizione.setIdIscrizione(iscrizioneId);
        return presenzaService.getPresenzeByIscrizione(iscrizione).stream()
                .map(PresenzaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/presenza")
    public List<PresenzaDTO> getPresenzeByPresenza(@RequestParam Boolean presente) {
        return presenzaService.getPresenzeByPresenza(presente).stream()
                .map(PresenzaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/lezione/{lezioneId}/iscrizione/{iscrizioneId}")
    public ResponseEntity<PresenzaDTO> getPresenzaByLezioneAndIscrizione(
            @PathVariable Long lezioneId, @PathVariable Long iscrizioneId) {
        Lezione lezione = new Lezione();
        lezione.setIdLezione(lezioneId);
        Iscrizione iscrizione = new Iscrizione();
        iscrizione.setIdIscrizione(iscrizioneId);
        Presenza presenza = presenzaService.getPresenzaByLezioneAndIscrizione(lezione, iscrizione);
        return presenza != null ? ResponseEntity.ok(PresenzaMapper.toDTO(presenza)) : ResponseEntity.notFound().build();
    }

    @GetMapping("/count/iscrizione/{iscrizioneId}")
    public Integer countPresenzeByIscrizione(@PathVariable Long iscrizioneId) {
        return presenzaService.countPresenzeByIscrizioneId(iscrizioneId);
    }

    @GetMapping("/count/lezione/{lezioneId}")
    public Integer countPresenzeByLezione(@PathVariable Long lezioneId) {
        return presenzaService.countPresenzeByLezioneId(lezioneId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PresenzaDTO> updatePresenza(@PathVariable Long id, @RequestBody PresenzaDTO presenzaDTO) {
        Presenza updated = presenzaService.updatePresenza(id, PresenzaMapper.toEntity(presenzaDTO));
        return updated != null ? ResponseEntity.ok(PresenzaMapper.toDTO(updated)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePresenza(@PathVariable Long id) {
        presenzaService.deletePresenza(id);
        return ResponseEntity.noContent().build();
    }
}
