package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    private String email;

    private String genero;

    private String numeroWpp;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dependentes> dependentes;

    /* Endereço */
    @Column(nullable = true)
    private String rua;
    @Column(nullable = true)
    private Long numero;
    @Column(nullable = true)
    private String complemento;
    @Column(nullable = true)
    private String cep;
    @Column(nullable = true)
    private String cidade;
    @Column(nullable = true)
    private String uf;
}
