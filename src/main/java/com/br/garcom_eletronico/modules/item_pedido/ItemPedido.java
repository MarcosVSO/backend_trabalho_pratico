package com.br.garcom_eletronico.modules.item_pedido;

import com.br.garcom_eletronico.modules.item_cardapio.ItemCardapio;
import com.br.garcom_eletronico.modules.pedido.Pedido;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ItemCardapio itemCardapio;

    private Integer quantidade;

    @ManyToOne
    private Pedido pedido;
}
