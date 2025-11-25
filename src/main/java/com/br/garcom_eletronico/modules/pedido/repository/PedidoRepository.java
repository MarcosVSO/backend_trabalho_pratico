package com.br.garcom_eletronico.modules.pedido.repository;

import com.br.garcom_eletronico.modules.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

