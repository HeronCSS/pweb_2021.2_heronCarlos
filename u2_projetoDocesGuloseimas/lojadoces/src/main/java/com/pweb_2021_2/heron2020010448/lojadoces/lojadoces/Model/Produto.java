package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "increment")
    private Long id;

    private String nomeProduto;

    private String marca;

    private double altura;

    private double largura;

    private double profundidade;

    private double volume;

    private double peso;

    private double precoCompra;

    private double precoVenda;

    private String dataCadastro;
    
    private int vezesVendido;

    private String linkImg;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Pedido pedidos;
}
