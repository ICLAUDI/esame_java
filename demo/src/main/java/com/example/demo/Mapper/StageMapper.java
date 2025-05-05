package com.example.demo.Mapper;

import com.example.demo.model.Stage;
import com.example.demo.Dto.StageDTO;

public class StageMapper {

    // Converte un Stage in un StageDTO
    public static StageDTO toDTO(Stage stage) {
        if (stage == null) {
            return null;
        }
        return new StageDTO(
            stage.getIdStage(),
            stage.getCorso().getIdCorso(),
            stage.getPartner().getIdPartner(),
            stage.getStudente().getIdStudente(),
            stage.getDataInizio(),
            stage.getDataFine(),
            stage.getRuolo(),
            stage.getDescrizione(),
            stage.getRetribuito()
        );
    }

    // Converte un StageDTO in uno Stage
    public static Stage toEntity(StageDTO stageDTO) {
        if (stageDTO == null) {
            return null;
        }
        Stage stage = new Stage();
        stage.setIdStage(stageDTO.getIdStage());
        stage.setDataInizio(stageDTO.getDataInizio());
        stage.setDataFine(stageDTO.getDataFine());
        stage.setRuolo(stageDTO.getRuolo());
        stage.setDescrizione(stageDTO.getDescrizione());
        stage.setRetribuito(stageDTO.getRetribuito());
        return stage;
    }
}
