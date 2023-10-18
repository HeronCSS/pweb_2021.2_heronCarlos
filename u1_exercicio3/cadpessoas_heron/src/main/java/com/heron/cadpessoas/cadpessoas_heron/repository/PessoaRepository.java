package com.heron.cadpessoas.cadpessoas_heron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.heron.cadpessoas.cadpessoas_heron.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    @Modifying
    @Query("update Pessoa p set sequencia_decisao = ?2 where p.id_pessoa = ?1")
    void updateSequenciaDecisaoById(Long id, Long resposta);
}
