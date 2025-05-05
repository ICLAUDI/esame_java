package com.example.demo.Mapper;

import com.example.demo.Dto.LezioneDTO;
import com.example.demo.model.Aula;
import com.example.demo.model.Corso;
import com.example.demo.model.Docente;
import com.example.demo.model.Lezione;

public class LezioneMapper {

    public static LezioneDTO toDTO(Lezione lezione) {
        if (lezione == null) return null;

        return new LezioneDTO(
                lezione.getIdLezione(),
                lezione.getCorso().getIdCorso(),
                lezione.getDocente().getIdDocente(),
                lezione.getAula().getIdAula(),
                lezione.getData(),
                lezione.getOraInizio(),
                lezione.getOraFine(),
                lezione.getArgomento()
        );
    }

    public static Lezione toEntity(LezioneDTO dto, Corso corso, Docente docente, Aula aula) {
        if (dto == null) return null;

        Lezione lezione = new Lezione();
        lezione.setIdLezione(dto.getIdLezione());
        lezione.setCorso(corso);
        lezione.setDocente(docente);
        lezione.setAula(aula);
        lezione.setData(dto.getData());
        lezione.setOraInizio(dto.getOraInizio());
        lezione.setOraFine(dto.getOraFine());
        lezione.setArgomento(dto.getArgomento());
        return lezione;
    }
}
