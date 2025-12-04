package com.br.garcom_eletronico.modules.pedido.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PedidoDTO {
    private Long id;
    private Long clienteId;
    private LocalDateTime dataPedido;
    private LocalDateTime horaEntrega;
    private Integer contaId;
    private Integer mesaId;
}

