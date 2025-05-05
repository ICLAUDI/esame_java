package com.example.demo.Mapper;

import com.example.demo.Dto.IscrizioneDTO;
import com.example.demo.model.Corso;
import com.example.demo.model.Iscrizione;
import com.example.demo.model.Studente;

public class IscrizioneMapper {

    public static IscrizioneDTO toDTO(Iscrizione iscrizione) {
        return new IscrizioneDTO(
            iscrizione.getIdIscrizione(),
            iscrizione.getStudente().getIdStudente(),
            iscrizione.getCorso().getIdCorso(),
            iscrizione.getDataIscrizione(),
            iscrizione.getStato(),
            iscrizione.getImportoPagato(),
            iscrizione.getCompletato()
        );
    }

    public static Iscrizione toEntity(IscrizioneDTO dto, Studente studente, Corso corso) {
        Iscrizione iscrizione = new Iscrizione();
        iscrizione.setIdIscrizione(dto.getIdIscrizione());
        iscrizione.setStudente(studente);
        iscrizione.setCorso(corso);
        iscrizione.setDataIscrizione(dto.getDataIscrizione());
        iscrizione.setStato(dto.getStato());
        iscrizione.setImportoPagato(dto.getImportoPagato());
        iscrizione.setCompletato(dto.getCompletato());
        return iscrizione;
    }
}
