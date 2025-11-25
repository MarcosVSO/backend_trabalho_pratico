package com.br.garcom_eletronico.modules.pagamento;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Cartao extends Pagamento {

    private String numeroCartao;
}
