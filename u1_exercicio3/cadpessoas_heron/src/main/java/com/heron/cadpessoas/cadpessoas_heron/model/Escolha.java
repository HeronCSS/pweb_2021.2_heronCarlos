package com.heron.cadpessoas.cadpessoas_heron.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Escolha {

    @Id
    private Long id;

    @Column(length = 5000)
    private String fraseDeEscolha;

    @Column(length = 5000)
    private HashMap<String, Long> escolhas = new LinkedHashMap<>();
    
    public Escolha(){

    }

    public Escolha(Long id, String fraseDeEscolha, HashMap<String, Long> escolhas){
        this.id = id;
        this.fraseDeEscolha = fraseDeEscolha;
        this.escolhas = escolhas;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFraseDeEscolha() {
        return this.fraseDeEscolha;
    }

    public void setFraseDeEscolha(String fraseDeEscolha) {
        this.fraseDeEscolha = fraseDeEscolha;
    }

    public HashMap<String,Long> getEscolhas() {
        return this.escolhas;
    }

    public void setEscolhas(HashMap<String,Long> escolhas) {
        this.escolhas = escolhas;
    }


}
