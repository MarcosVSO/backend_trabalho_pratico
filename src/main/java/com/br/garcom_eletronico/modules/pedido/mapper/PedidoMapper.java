package com.br.garcom_eletronico.modules.pedido.mapper;

import com.br.garcom_eletronico.modules.pedido.Pedido;
import com.br.garcom_eletronico.modules.pedido.dto.PedidoDTO;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public PedidoDTO toDto(Pedido entity) {
        if (entity == null) {
            return null;
        }
        PedidoDTO dto = new PedidoDTO();
        dto.setId(entity.getId());
        if (entity.getCliente() != null) {
            dto.setClienteId(entity.getCliente().getId());
        }
        dto.setDataPedido(entity.getDataPedido());
        dto.setHoraEntrega(entity.getHoraEntrega());
        if (entity.getConta() != null) {
            dto.setContaId(entity.getConta().getId());
        }
        if (entity.getMesa() != null) {
            dto.setMesaId(entity.getMesa().getNumero());
        }
        return dto;
    }

    public Pedido toEntity(PedidoDTO dto) {
        if (dto == null) {
            return null;
        }
        Pedido entity = new Pedido();
        entity.setId(dto.getId());
        entity.setDataPedido(dto.getDataPedido());
        entity.setHoraEntrega(dto.getHoraEntrega());
        return entity;
    }

    public void updateEntityFromDto(PedidoDTO dto, Pedido entity) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setDataPedido(dto.getDataPedido());
        entity.setHoraEntrega(dto.getHoraEntrega());
    }
}

