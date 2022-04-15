package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.enums;

import lombok.Getter;

@Getter
public enum FormaPagamento {
    CARTAO("Cartão de Crédito"),
    DINHEIRO("Dinheiro"),
    PIX("Chave do Pix");

    private String pagamento;

    FormaPagamento(String pagamento){
        this.pagamento = pagamento;
    }
}
