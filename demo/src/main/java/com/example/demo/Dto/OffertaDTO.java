package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OffertaDTO {
    private Long id;
    private Long partnerId;
    private String descrizione;
    private String requisiti;
    private LocalDate dataPubblicazione;
    private LocalDate dataScadenza;
    private String tipoOfferta;
    private Double prezzoOriginale;
    private Double prezzoScontato;
}
