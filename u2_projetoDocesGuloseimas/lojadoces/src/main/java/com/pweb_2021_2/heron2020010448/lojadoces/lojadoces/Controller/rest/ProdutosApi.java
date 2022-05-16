package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Controller.rest;

import javax.websocket.server.PathParam;

import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model.Produto;
import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosApi {
    
    @Autowired
    ProdutoRepository produtoRepo;

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<Produto> getProduto(@PathVariable Long id) throws Exception{
        return new ResponseEntity<Produto>(produtoRepo.findById(id).orElseThrow(()-> new Exception()), HttpStatus.OK);
    }
}
