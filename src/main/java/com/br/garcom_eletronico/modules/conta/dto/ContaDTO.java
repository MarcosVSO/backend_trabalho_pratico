package com.br.garcom_eletronico.modules.conta.dto;

import lombok.Data;

@Data
public class ContaDTO {
    private Integer id;
    private String nome;
    private Long pagamentoId;
}