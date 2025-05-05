package com.example.demo.Mapper;

import com.example.demo.Dto.DocenteDTO;
import com.example.demo.model.Docente;

import java.util.List;
import java.util.stream.Collectors;

public class DocenteMapper {

    public static DocenteDTO toDto(Docente docente) {
        List<Long> corsiIds = docente.getCorsi().stream()
                                     .map(corso -> corso.getIdCorso())
                                     .collect(Collectors.toList());

        return new DocenteDTO(
                docente.getIdDocente(),
                docente.getNome(),
                docente.getCognome(),
                docente.getEmail(),
                docente.getPassword(),            // <--- aggiunto
                docente.getTelefono(),
                docente.getSpecializzazione(),
                docente.getRuolo(),
                corsiIds
        );
    }

    public static Docente toEntity(DocenteDTO docenteDTO) {
        Docente docente = new Docente();
        docente.setIdDocente(docenteDTO.getIdDocente());
        docente.setNome(docenteDTO.getNome());
        docente.setCognome(docenteDTO.getCognome());
        docente.setEmail(docenteDTO.getEmail());
        docente.setPassword(docenteDTO.getPassword());  // <--- aggiunto
        docente.setTelefono(docenteDTO.getTelefono());
        docente.setSpecializzazione(docenteDTO.getSpecializzazione());
        docente.setRuolo(docenteDTO.getRuolo());

        return docente;
    }
}
