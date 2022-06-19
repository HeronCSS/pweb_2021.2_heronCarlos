package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Repositories;

import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model.Pessoa;
import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model.Produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    @Query("SELECT prod FROM Produto prod WHERE prod.nomeProduto LIKE %:nomeE%")
    List<Produto> findByNome(@Param("nomeE") String nome);
}
