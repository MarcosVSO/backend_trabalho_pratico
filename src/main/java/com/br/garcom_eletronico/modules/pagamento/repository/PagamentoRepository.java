package com.br.garcom_eletronico.modules.pagamento.repository;

import com.br.garcom_eletronico.modules.pagamento.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}