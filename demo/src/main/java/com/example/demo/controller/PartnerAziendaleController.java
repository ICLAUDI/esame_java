package com.example.demo.controller;

import com.example.demo.model.PartnerAziendale;
import com.example.demo.service.PartnerAziendaleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/partner-aziendali")
public class PartnerAziendaleController {

    private final PartnerAziendaleService partnerAziendaleService;

    public PartnerAziendaleController(PartnerAziendaleService partnerAziendaleService) {
        this.partnerAziendaleService = partnerAziendaleService;
    }

    @PostMapping
    public PartnerAziendale createPartnerAziendale(@RequestBody PartnerAziendale partnerAziendale) {
        return partnerAziendaleService.savePartnerAziendale(partnerAziendale);
    }

    @GetMapping("/{id}")
    public PartnerAziendale getPartnerAziendaleById(@PathVariable Long id) {
        return partnerAziendaleService.getPartnerAziendaleById(id);
    }

    @GetMapping("/partita-iva/{partitaIva}")
    public Optional<PartnerAziendale> getPartnerAziendaleByPartitaIva(@PathVariable String partitaIva) {
        return partnerAziendaleService.getPartnerAziendaleByPartitaIva(partitaIva);
    }

    @GetMapping("/settore/{settore}")
    public List<PartnerAziendale> getPartnerAziendaleBySettore(@PathVariable String settore) {
        return partnerAziendaleService.getPartnerAziendaleBySettore(settore);
    }

    @GetMapping("/ordinati-per-numero-stage")
    public List<PartnerAziendale> getAllPartnerAziendaliOrderedByNumeroStage() {
        return partnerAziendaleService.getAllPartnerAziendaliOrderedByNumeroStage();
    }

    @GetMapping("/convenzione-recente")
    public List<PartnerAziendale> getPartnerAziendaliWithRecentConvenzione(@RequestParam LocalDate data) {
        return partnerAziendaleService.getPartnerAziendaliWithRecentConvenzione(data);
    }

    @DeleteMapping("/{id}")
    public void deletePartnerAziendale(@PathVariable Long id) {
        partnerAziendaleService.deletePartnerAziendale(id);
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return partnerAziendaleService.existsById(id);
    }
}
