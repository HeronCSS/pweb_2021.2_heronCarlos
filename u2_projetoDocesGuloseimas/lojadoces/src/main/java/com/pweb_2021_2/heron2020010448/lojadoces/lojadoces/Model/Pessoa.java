package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "increment")
    @Column(name = "id_pessoa")
    private Long idPessoa;

    private String nome;

    private String cpf;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dataNascimento;

    private String email;

    private String genero;

    private String numeroWpp;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dependentes> dependentes;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    /* Endereço */
    private String rua;

    private Long numero;

    private String complemento;

    private String cep;

    private String cidade;

    private String uf;

}
