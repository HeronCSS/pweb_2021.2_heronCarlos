package com.heron.cadpessoas.cadpessoas_heron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heron.cadpessoas.cadpessoas_heron.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
