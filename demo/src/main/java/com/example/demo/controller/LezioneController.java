package com.example.demo.controller;

import com.example.demo.Dto.LezioneDTO;
import com.example.demo.Mapper.LezioneMapper;
import com.example.demo.model.Aula;
import com.example.demo.model.Corso;
import com.example.demo.model.Docente;
import com.example.demo.model.Lezione;
import com.example.demo.repository.AulaRepository;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.repository.DocenteRepository;
import com.example.demo.service.LezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/lezioni")
public class LezioneController {

    @Autowired
    private LezioneService lezioneService;

    @Autowired
    private CorsoRepository corsoRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private AulaRepository aulaRepository;

    @GetMapping
    public List<LezioneDTO> getAll() {
        return lezioneService.getAllLezioni().stream()
                .map(LezioneMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public LezioneDTO getById(@PathVariable Long id) {
        return LezioneMapper.toDTO(lezioneService.getLezioneById(id));
    }

    @PostMapping
    public LezioneDTO create(@RequestBody LezioneDTO dto) {
        Corso corso = corsoRepository.findById(dto.getIdCorso()).orElseThrow();
        Docente docente = docenteRepository.findById(dto.getIdDocente()).orElseThrow();
        Aula aula = aulaRepository.findById(dto.getIdAula()).orElseThrow();
        Lezione lezione = LezioneMapper.toEntity(dto, corso, docente, aula);
        return LezioneMapper.toDTO(lezioneService.createLezione(lezione));
    }

    @PutMapping("/{id}")
    public LezioneDTO update(@PathVariable Long id, @RequestBody LezioneDTO dto) {
        Corso corso = corsoRepository.findById(dto.getIdCorso()).orElseThrow();
        Docente docente = docenteRepository.findById(dto.getIdDocente()).orElseThrow();
        Aula aula = aulaRepository.findById(dto.getIdAula()).orElseThrow();
        Lezione lezione = LezioneMapper.toEntity(dto, corso, docente, aula);
        return LezioneMapper.toDTO(lezioneService.updateLezione(id, lezione));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lezioneService.deleteLezione(id);
    }

    @GetMapping("/data")
    public List<LezioneDTO> getByData(@RequestParam Date data) {
        return lezioneService.getByData(data).stream()
                .map(LezioneMapper::toDTO)
                .toList();
    }

    @GetMapping("/data-range")
    public List<LezioneDTO> getByDateRange(@RequestParam Date start, @RequestParam Date end) {
        return lezioneService.getByDataBetween(start, end).stream()
                .map(LezioneMapper::toDTO)
                .toList();
    }

    @GetMapping("/argomento")
    public List<LezioneDTO> getByArgomento(@RequestParam String argomento) {
        return lezioneService.getByArgomento(argomento).stream()
                .map(LezioneMapper::toDTO)
                .toList();
    }

    @GetMapping("/corso")
    public List<LezioneDTO> getByCorso(@RequestParam Long corsoId) {
        Corso corso = corsoRepository.findById(corsoId).orElseThrow();
        return lezioneService.getByCorso(corso).stream()
                .map(LezioneMapper::toDTO)
                .toList();
    }

    @GetMapping("/docente")
    public List<LezioneDTO> getByDocente(@RequestParam Long docenteId) {
        Docente docente = docenteRepository.findById(docenteId).orElseThrow();
        return lezioneService.getByDocente(docente).stream()
                .map(LezioneMapper::toDTO)
                .toList();
    }

    @GetMapping("/aula")
    public List<LezioneDTO> getByAula(@RequestParam Long aulaId) {
        Aula aula = aulaRepository.findById(aulaId).orElseThrow();
        return lezioneService.getByAula(aula).stream()
                .map(LezioneMapper::toDTO)
                .toList();
    }

    @GetMapping("/check-overlap")
    public List<LezioneDTO> checkTimeOverlap(
            @RequestParam Long aulaId,
            @RequestParam Date data,
            @RequestParam String oraInizio,
            @RequestParam String oraFine
    ) {
        Aula aula = aulaRepository.findById(aulaId).orElseThrow();
        return lezioneService.getByAulaAndDataAndTimeOverlap(aula, data, oraFine, oraInizio)
                .stream()
                .map(LezioneMapper::toDTO)
                .toList();
    }
}
