package com.br.garcom_eletronico.modules.cliente.repository;

import com.br.garcom_eletronico.modules.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findAll();
    
    @Query(value = "SELECT * FROM cliente ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Cliente> findRandomCliente();

    @Query(
            value = """
                SELECT *
                FROM cliente
                WHERE EXTRACT(DAY FROM data_nascimento) = :dia
                  AND EXTRACT(MONTH FROM data_nascimento) = :mes
                """,
            nativeQuery = true
    )
    List<Cliente> findAniversariantes(@Param("dia") int dia, @Param("mes") int mes);
}