package com.heron.cadpessoas.cadpessoas_heron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(name = "data_nascimento")
    private String dataNascimento;


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

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Pessoa dataNascimento(String dataNascimento) {
        setDataNascimento(dataNascimento);
        return this;
    }

}
