package com.example.demo.controller;

import com.example.demo.Dto.AulaDTO;
import com.example.demo.Mapper.AulaMapper;
import com.example.demo.model.Aula;
import com.example.demo.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/aule")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    // Ottieni tutte le aule
    @GetMapping
    public List<AulaDTO> getAll() {
        List<Aula> aule = aulaService.getAllAule();
        return aule.stream()
                   .map(AulaMapper::toDTO)  // Mappiamo ogni Aula in AulaDTO
                   .collect(Collectors.toList());
    }

    // Ottieni aula per ID
    @GetMapping("/{id}")
    public Optional<AulaDTO> getById(@PathVariable Long id) {
        Optional<Aula> aula = aulaService.getAulaById(id);
        return aula.map(AulaMapper::toDTO);  // Se l'Aula esiste, la mappiamo in AulaDTO
    }

    // Crea una nuova aula
    @PostMapping
    public AulaDTO create(@RequestBody AulaDTO aulaDTO) {
        Aula aula = AulaMapper.toEntity(aulaDTO);  // Convertiamo AulaDTO in Aula
        aula = aulaService.saveAula(aula);         // Salviamo l'entità nel database
        return AulaMapper.toDTO(aula);            // Restituiamo il DTO del corso appena creato
    }

    // Aggiorna una aula esistente
    @PutMapping("/{id}")
    public AulaDTO update(@PathVariable Long id, @RequestBody AulaDTO aulaDTO) {
        Aula aula = AulaMapper.toEntity(aulaDTO);  // Convertiamo AulaDTO in Aula
        aula.setIdAula(id);  // Impostiamo l'ID per aggiornare l'Aula
        aula = aulaService.updateAula(id, aula);  // Aggiorniamo l'Aula nel database
        return AulaMapper.toDTO(aula);  // Restituiamo il DTO della Aula aggiornata
    }

    // Elimina un'aula
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        aulaService.deleteAula(id);  // Eliminiamo l'Aula dal database
    }

    // Cerca aula per nome
    @GetMapping("/search/nome")
    public List<AulaDTO> searchByNome(@RequestParam String nome) {
        List<Aula> aule = aulaService.searchByNome(nome);
        return aule.stream()
                   .map(AulaMapper::toDTO)  // Mappiamo ogni Aula in AulaDTO
                   .collect(Collectors.toList());
    }

    // Cerca aula per edificio
    @GetMapping("/search/edificio")
    public List<AulaDTO> searchByEdificio(@RequestParam String edificio) {
        List<Aula> aule = aulaService.searchByEdificio(edificio);
        return aule.stream()
                   .map(AulaMapper::toDTO)  // Mappiamo ogni Aula in AulaDTO
                   .collect(Collectors.toList());
    }

    // Cerca aula per capacità
    @GetMapping("/search/capacita")
    public List<AulaDTO> searchByCapacita(@RequestParam Integer capacita) {
        List<Aula> aule = aulaService.searchByCapacita(capacita);
        return aule.stream()
                   .map(AulaMapper::toDTO)  // Mappiamo ogni Aula in AulaDTO
                   .collect(Collectors.toList());
    }

    // Cerca aula per accessibilità
    @GetMapping("/search/accessibile")
    public List<AulaDTO> searchByAccessibile(@RequestParam Boolean accessibile) {
        List<Aula> aule = aulaService.searchByAccessibile(accessibile);
        return aule.stream()
                   .map(AulaMapper::toDTO)  // Mappiamo ogni Aula in AulaDTO
                   .collect(Collectors.toList());
    }
}
