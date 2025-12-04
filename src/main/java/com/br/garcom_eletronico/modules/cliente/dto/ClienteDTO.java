package com.br.garcom_eletronico.modules.cliente.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClienteDTO {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private LocalDateTime horaChegada;
    private LocalDateTime horaSaida;
}