package com.br.garcom_eletronico.modules.pedido.repository;

import com.br.garcom_eletronico.modules.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    List<Pedido> findByMesaNumero(Integer mesaNumero);
    
    @Query("SELECT p FROM Pedido p WHERE p.horaEntrega IS NULL")
    List<Pedido> findPedidosPendentes();
    
    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = :clienteId ORDER BY p.dataPedido DESC")
    List<Pedido> findByClienteIdOrderByDataPedidoDesc(Long clienteId);
    
    @Query("SELECT p FROM Pedido p WHERE p.horaEntrega IS NOT NULL")
    List<Pedido> findAllComEntrega();
}