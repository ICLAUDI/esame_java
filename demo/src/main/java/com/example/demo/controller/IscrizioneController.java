package com.example.demo.controller;

import com.example.demo.Dto.IscrizioneDTO;
import com.example.demo.Mapper.IscrizioneMapper;
import com.example.demo.model.Corso;
import com.example.demo.model.Iscrizione;
import com.example.demo.model.Studente;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.repository.StudenteRepository;
import com.example.demo.service.IscrizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/iscrizioni")
public class IscrizioneController {

    @Autowired
    private IscrizioneService iscrizioneService;

    @Autowired
    private StudenteRepository studenteRepository;

    @Autowired
    private CorsoRepository corsoRepository;

    @GetMapping
    public List<IscrizioneDTO> getAll() {
        return iscrizioneService.getAllIscrizioni().stream()
                .map(IscrizioneMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public IscrizioneDTO getById(@PathVariable Long id) {
        return IscrizioneMapper.toDTO(iscrizioneService.getIscrizioneById(id));
    }

    @PostMapping
    public IscrizioneDTO create(@RequestBody IscrizioneDTO dto) {
        Studente studente = studenteRepository.findById(dto.getIdStudente()).orElseThrow();
        Corso corso = corsoRepository.findById(dto.getIdCorso()).orElseThrow();
        Iscrizione iscrizione = IscrizioneMapper.toEntity(dto, studente, corso);
        return IscrizioneMapper.toDTO(iscrizioneService.createIscrizione(iscrizione));
    }

    @PutMapping("/{id}")
    public IscrizioneDTO update(@PathVariable Long id, @RequestBody IscrizioneDTO dto) {
        Studente studente = studenteRepository.findById(dto.getIdStudente()).orElseThrow();
        Corso corso = corsoRepository.findById(dto.getIdCorso()).orElseThrow();
        Iscrizione iscrizione = IscrizioneMapper.toEntity(dto, studente, corso);
        return IscrizioneMapper.toDTO(iscrizioneService.updateIscrizione(id, iscrizione));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        iscrizioneService.deleteIscrizione(id);
    }

    @GetMapping("/stato")
    public List<IscrizioneDTO> getByStato(@RequestParam String stato) {
        return iscrizioneService.getByStato(stato).stream()
                .map(IscrizioneMapper::toDTO)
                .toList();
    }

    @GetMapping("/completato")
    public List<IscrizioneDTO> getByCompletato(@RequestParam Boolean completato) {
        return iscrizioneService.getByCompletato(completato).stream()
                .map(IscrizioneMapper::toDTO)
                .toList();
    }

    @GetMapping("/date")
    public List<IscrizioneDTO> getByDateRange(@RequestParam Date start, @RequestParam Date end) {
        return iscrizioneService.getByDateRange(start, end).stream()
                .map(IscrizioneMapper::toDTO)
                .toList();
    }

    @GetMapping("/conta/{corsoId}")
    public Integer countByCorso(@PathVariable Long corsoId) {
        return iscrizioneService.countByCorsoId(corsoId);
    }

    @GetMapping("/studente-corso")
    public List<IscrizioneDTO> getByStudenteAndCorso(@RequestParam Long idStudente, @RequestParam Long idCorso) {
        Studente studente = studenteRepository.findById(idStudente).orElseThrow();
        Corso corso = corsoRepository.findById(idCorso).orElseThrow();
        return iscrizioneService.getByStudenteAndCorso(studente, corso).stream()
                .map(IscrizioneMapper::toDTO)
                .toList();
    }
}
