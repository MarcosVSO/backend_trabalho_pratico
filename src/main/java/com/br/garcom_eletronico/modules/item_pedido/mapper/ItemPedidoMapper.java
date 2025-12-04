package com.br.garcom_eletronico.modules.item_pedido.mapper;

import com.br.garcom_eletronico.modules.item_pedido.ItemPedido;
import com.br.garcom_eletronico.modules.item_pedido.dto.ItemPedidoDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoMapper {

    public ItemPedidoDTO toDto(ItemPedido entity) {
        if (entity == null) {
            return null;
        }
        ItemPedidoDTO dto = new ItemPedidoDTO();
        dto.setId(entity.getId());
        if (entity.getItemCardapio() != null) {
            dto.setItemCardapioId(entity.getItemCardapio().getId());
        }
        dto.setQuantidade(entity.getQuantidade());
        if (entity.getPedido() != null) {
            dto.setPedidoId(entity.getPedido().getId());
        }
        return dto;
    }

    public ItemPedido toEntity(ItemPedidoDTO dto) {
        if (dto == null) {
            return null;
        }
        ItemPedido entity = new ItemPedido();
        entity.setId(dto.getId());
        entity.setQuantidade(dto.getQuantidade());
        return entity;
    }

    public void updateEntityFromDto(ItemPedidoDTO dto, ItemPedido entity) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setQuantidade(dto.getQuantidade());
    }
}