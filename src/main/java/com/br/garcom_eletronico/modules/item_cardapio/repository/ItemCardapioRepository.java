package com.br.garcom_eletronico.modules.item_cardapio.repository;

import com.br.garcom_eletronico.modules.item_cardapio.ItemCardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Long> {
    
    List<ItemCardapio> findByCategoriaNome(String categoriaNome);
    
    @Query("SELECT ip.itemCardapio, SUM(ip.quantidade) as total " +
           "FROM ItemPedido ip " +
           "GROUP BY ip.itemCardapio " +
           "ORDER BY total DESC")
    List<Object[]> findItensMaisPedidos();
}


