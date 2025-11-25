package com.br.garcom_eletronico.modules.conta;


import com.br.garcom_eletronico.modules.pagamento.Pagamento;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @OneToOne
    private Pagamento pagamento;
}
