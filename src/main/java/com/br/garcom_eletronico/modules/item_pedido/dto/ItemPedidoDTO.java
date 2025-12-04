package com.br.garcom_eletronico.modules.item_pedido.dto;

import lombok.Data;

@Data
public class ItemPedidoDTO {
    private Long id;
    private Long itemCardapioId;
    private Integer quantidade;
    private Long pedidoId;
}