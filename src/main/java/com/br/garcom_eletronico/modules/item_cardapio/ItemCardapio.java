package com.br.garcom_eletronico.modules.item_cardapio;

import com.br.garcom_eletronico.modules.categoria.Categoria;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ItemCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ingredientes;

    private Float preco;

    private Boolean disponivelNaCozinha;

    @ManyToOne
    private Categoria categoria;
}
