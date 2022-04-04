package com.heron.cadpessoas.cadpessoas_heron.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id_pessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "sexo")
    private String sexo;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "data_nascimento")
    private Date dataNascimento;


    public Long getId_pessoa() {
        return this.id_pessoa;
    }

    public void setId_pessoa(Long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public Pessoa id_pessoa(Long id_pessoa) {
        setId_pessoa(id_pessoa);
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa nome(String nome) {
        setNome(nome);
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa email(String email) {
        setEmail(email);
        return this;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Pessoa sexo(String sexo) {
        setSexo(sexo);
        return this;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Pessoa dataNascimento(Date dataNascimento) {
        setDataNascimento(dataNascimento);
        return this;
    }

}
