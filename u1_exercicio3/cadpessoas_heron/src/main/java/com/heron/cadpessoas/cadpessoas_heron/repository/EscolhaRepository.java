package com.heron.cadpessoas.cadpessoas_heron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heron.cadpessoas.cadpessoas_heron.model.Escolha;

@Repository
public interface EscolhaRepository extends JpaRepository<Escolha, Long> {
    
}
