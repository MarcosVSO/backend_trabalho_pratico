package com.br.garcom_eletronico.modules.pedido;

import com.br.garcom_eletronico.modules.garcom.Garcom;
import com.br.garcom_eletronico.modules.item_pedido.ItemPedido;
import com.br.garcom_eletronico.modules.mesa.Mesa;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Mesa mesa;

    @ManyToOne
    private Garcom garcom;

    private LocalDateTime dataHoraCriacao;

    private String status; // ABERTO, EM_PREPARO, ENTREGUE, FINALIZADO

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens;
}
