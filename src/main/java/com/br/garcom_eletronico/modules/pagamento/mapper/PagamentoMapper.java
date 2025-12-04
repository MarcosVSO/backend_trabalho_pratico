package com.br.garcom_eletronico.modules.pagamento.mapper;

import com.br.garcom_eletronico.modules.pagamento.Pagamento;
import com.br.garcom_eletronico.modules.pagamento.dto.PagamentoDTO;
import org.springframework.stereotype.Component;

@Component
public class PagamentoMapper {

    public PagamentoDTO toDto(Pagamento entity) {
        if (entity == null) {
            return null;
        }
        PagamentoDTO dto = new PagamentoDTO();
        dto.setId(entity.getId());
        dto.setTipo(entity.getClass().getSimpleName());
        return dto;
    }

    public Pagamento toEntity(PagamentoDTO dto) {
        if (dto == null) {
            return null;
        }
        Pagamento entity = new Pagamento();
        entity.setId(dto.getId());
        return entity;
    }

    public void updateEntityFromDto(PagamentoDTO dto, Pagamento entity) {
        if (dto == null || entity == null) {
            return;
        }
    }
}