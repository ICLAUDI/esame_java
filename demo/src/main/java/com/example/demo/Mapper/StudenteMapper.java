package com.example.demo.Mapper;

import com.example.demo.Dto.StudenteDTO;
import com.example.demo.model.Studente;

public class StudenteMapper {

    // Converti da Entity a DTO
    public static StudenteDTO toDTO(Studente studente) {
        if (studente == null) {
            return null;
        }
        return new StudenteDTO(
            studente.getIdStudente(),
            studente.getNome(),
            studente.getCognome(),
            studente.getEmail(),
            studente.getPassword(),  // nuovo
            studente.getRuolo(),     // nuovo
            studente.getTelefono(),
            studente.getDataNascita(),
            studente.getIndirizzo(),
            studente.getTitoloStudio(),
            studente.getDataIscrizione()
        );
    }

    // Converti da DTO a Entity
    public static Studente toEntity(StudenteDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Studente(
            dto.getIdStudente(),
            dto.getNome(),
            dto.getCognome(),
            dto.getEmail(),
            dto.getPassword(),   // nuovo
            dto.getRuolo(),      // nuovo
            dto.getTelefono(),
            dto.getDataNascita(),
            dto.getIndirizzo(),
            dto.getTitoloStudio(),
            dto.getDataIscrizione()
        );
    }
}
