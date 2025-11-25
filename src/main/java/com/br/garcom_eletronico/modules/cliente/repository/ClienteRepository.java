package com.br.garcom_eletronico.modules.cliente.repository;

import com.br.garcom_eletronico.modules.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

