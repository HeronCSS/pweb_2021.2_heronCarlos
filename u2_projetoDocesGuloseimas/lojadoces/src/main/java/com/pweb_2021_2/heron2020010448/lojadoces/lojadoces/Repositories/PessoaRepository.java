package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Repositories;

import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model.Pessoa;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
    @Query("SELECT pessoa FROM Pessoa pessoa WHERE pessoa.nome LIKE %:nomeE%")
    List<Pessoa> findByNome(@Param("nomeE") String nome);

    @Query("SELECT pessoa FROM Pessoa pessoa WHERE pessoa.cpf = :cpfF")
    Pessoa findByCpf(@Param("cpfF") String cpf);
}
