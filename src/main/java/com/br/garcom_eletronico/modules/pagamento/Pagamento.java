package com.br.garcom_eletronico.modules.pagamento;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
