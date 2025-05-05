package com.example.demo.Mapper;

import com.example.demo.Dto.PagamentoDTO;
import com.example.demo.model.Pagamento;
import com.example.demo.model.Studente;

public class PagamentoMapper {

    public static PagamentoDTO toDTO(Pagamento pagamento) {
        PagamentoDTO dto = new PagamentoDTO();
        dto.setIdPagamento(pagamento.getIdPagamento());
        dto.setIdStudente(pagamento.getStudente().getIdStudente());
        dto.setImporto(pagamento.getImporto());
        dto.setDataPagamento(pagamento.getDataPagamento());
        dto.setMetodoPagamento(pagamento.getMetodoPagamento());
        dto.setStato(pagamento.getStato());
        dto.setRiferimento(pagamento.getRiferimento());
        return dto;
    }

    public static Pagamento toEntity(PagamentoDTO dto) {
        Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamento(dto.getIdPagamento());
        pagamento.setImporto(dto.getImporto());
        pagamento.setDataPagamento(dto.getDataPagamento());
        pagamento.setMetodoPagamento(dto.getMetodoPagamento());
        pagamento.setStato(dto.getStato());
        pagamento.setRiferimento(dto.getRiferimento());

        Studente studente = new Studente();
        studente.setIdStudente(dto.getIdStudente());
        pagamento.setStudente(studente);

        return pagamento;
    }
}
