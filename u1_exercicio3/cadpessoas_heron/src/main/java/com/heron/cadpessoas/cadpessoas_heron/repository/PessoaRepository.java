package com.heron.cadpessoas.cadpessoas_heron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.heron.cadpessoas.cadpessoas_heron.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
