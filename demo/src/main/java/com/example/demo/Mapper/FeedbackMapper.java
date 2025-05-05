package com.example.demo.Mapper;

import com.example.demo.Dto.FeedbackDTO;
import com.example.demo.model.Feedback;
import com.example.demo.model.Corso;
import com.example.demo.model.Studente;

public class FeedbackMapper {

    public static FeedbackDTO toDTO(Feedback feedback) {
        return new FeedbackDTO(
            feedback.getIdFeedback(),
            feedback.getStudente().getIdStudente(),
            feedback.getCorso().getIdCorso(),
            feedback.getValutazione(),
            feedback.getCommento(),
            feedback.getDataFeedback()
        );
    }

    public static Feedback toEntity(FeedbackDTO dto, Studente studente, Corso corso) {
        Feedback feedback = new Feedback();
        feedback.setIdFeedback(dto.getIdFeedback());
        feedback.setStudente(studente);
        feedback.setCorso(corso);
        feedback.setValutazione(dto.getValutazione());
        feedback.setCommento(dto.getCommento());
        feedback.setDataFeedback(dto.getDataFeedback());
        return feedback;
    }
}
