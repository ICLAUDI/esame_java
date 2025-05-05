package com.example.demo.Mapper;

import com.example.demo.Dto.PresenzaDTO;
import com.example.demo.model.Iscrizione;
import com.example.demo.model.Lezione;
import com.example.demo.model.Presenza;

public class PresenzaMapper {

    public static PresenzaDTO toDTO(Presenza presenza) {
        PresenzaDTO dto = new PresenzaDTO();
        dto.setIdPresenza(presenza.getIdPresenza());
        dto.setIdLezione(presenza.getLezione().getIdLezione());
        dto.setIdIscrizione(presenza.getIscrizione().getIdIscrizione());
        dto.setPresente(presenza.getPresente());
        dto.setNote(presenza.getNote());
        return dto;
    }

    public static Presenza toEntity(PresenzaDTO dto) {
        Presenza presenza = new Presenza();
        Lezione lezione = new Lezione();
        lezione.setIdLezione(dto.getIdLezione());
        Iscrizione iscrizione = new Iscrizione();
        iscrizione.setIdIscrizione(dto.getIdIscrizione());

        presenza.setIdPresenza(dto.getIdPresenza());
        presenza.setLezione(lezione);
        presenza.setIscrizione(iscrizione);
        presenza.setPresente(dto.getPresente());
        presenza.setNote(dto.getNote());

        return presenza;
    }
}
