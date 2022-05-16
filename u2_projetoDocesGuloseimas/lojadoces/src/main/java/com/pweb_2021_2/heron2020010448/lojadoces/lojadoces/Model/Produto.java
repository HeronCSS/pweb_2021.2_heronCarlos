package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

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

    /* @ManyToMany
    @JoinColumn(name = "produto_id")
    private List<Pedido> pedidos = new ArrayList<>(); */
}
