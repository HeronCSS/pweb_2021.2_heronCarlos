package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    private Date dataCadastro;
    
    private int vezesVendido;

}
