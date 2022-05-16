package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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

    private String formaPagamento;

    private double valorTotalProduto;

    private double valorTotalPago; //Com imposto

    private String codigoCartao;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Produto> produtos = new ArrayList<>();

    private String numeroCartao;



}