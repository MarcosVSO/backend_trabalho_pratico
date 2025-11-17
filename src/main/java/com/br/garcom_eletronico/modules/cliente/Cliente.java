package com.br.garcom_eletronico.modules.cliente;

import com.br.garcom_eletronico.modules.pedido.Pedido;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDateTime horaChegada;

    private LocalDateTime horaSaída;

    private List<Pedido> pedidos;
}
