package com.br.garcom_eletronico.modules.conta.repository;

import com.br.garcom_eletronico.modules.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
}