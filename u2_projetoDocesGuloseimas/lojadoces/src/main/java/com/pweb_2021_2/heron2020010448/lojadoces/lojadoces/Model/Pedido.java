package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.enums.FormaPagamento;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Pedido {
    
   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "increment")
    private Long id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dataDaVenda;

    private int qtdDesejada;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    private double valorTotalProduto;

    private double valorTotalPago; //Com imposto

    private String numeroCartão;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private List<Produto> produtos;

    private String numeroCartao;

    @OneToOne
    @JoinColumn(name = "id")
    private Pessoa cliente;

}