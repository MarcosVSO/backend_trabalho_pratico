package com.br.garcom_eletronico.modules.item_cardapio.dto;

import lombok.Data;

@Data
public class ItemCardapioDTO {
    private Long id;
    private String ingredientes;
    private Float preco;
    private Boolean disponivelNaCozinha;
    private Long categoriaId;
    private String categoriaNome;
}


