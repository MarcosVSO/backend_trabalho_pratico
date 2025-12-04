package com.br.garcom_eletronico.modules.cliente;

import com.br.garcom_eletronico.modules.pedido.Pedido;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private LocalDateTime horaChegada;

    private LocalDateTime horaSaida;

    @OneToMany
    private List<Pedido> pedidos;
}
