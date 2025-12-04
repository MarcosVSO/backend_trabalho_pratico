package com.br.garcom_eletronico.modules.categoria.repository;

import com.br.garcom_eletronico.modules.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}