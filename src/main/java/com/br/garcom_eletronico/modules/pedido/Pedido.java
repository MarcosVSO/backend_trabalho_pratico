package com.br.garcom_eletronico.modules.pedido;

import com.br.garcom_eletronico.modules.cliente.Cliente;
import com.br.garcom_eletronico.modules.conta.Conta;
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
    private Cliente cliente;

    private LocalDateTime dataPedido;

    private LocalDateTime horaEntrega;

    @OneToOne
    private Conta conta;

    @ManyToOne
    private Mesa mesa;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens;
}
