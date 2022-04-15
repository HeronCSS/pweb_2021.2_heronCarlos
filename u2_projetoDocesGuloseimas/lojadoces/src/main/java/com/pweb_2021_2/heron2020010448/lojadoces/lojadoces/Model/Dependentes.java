package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "dependentes")
public class Dependentes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "increment")
    private Long id;

    private String nome;

    private String genero;

    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa clienteQDepende;

}
