package com.heron.cadpessoas.cadpessoas_heron.controller;

import com.heron.cadpessoas.cadpessoas_heron.model.Pessoa;
import com.heron.cadpessoas.cadpessoas_heron.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdicionarPessoasController {

    @Autowired
    private PessoaRepository pessoaRepo;

    @GetMapping("/adicionarPessoa")
    public ModelAndView adicionarPessoa(){
        Pessoa pessoa = new Pessoa();
        ModelAndView mav = new ModelAndView("adicionarPessoa");
        mav.addObject("pessoa", pessoa);
        pessoaRepo.save(pessoa);
        return mav;
    }

    @PostMapping("/adicionarPessoa")
    public String adicionadaPessoa(Pessoa pessoa){
        pessoaRepo.save(pessoa);
        return "adicionadaComSucesso.html";
    }

    @GetMapping("/adicionarPessoa/listar")
    public ModelAndView pessoaAdicionada(){
        ModelAndView mav = new ModelAndView("listarPessoas");
        
        mav.addObject("pessoa", pessoaRepo.findAll());
        return mav;
    }

    @GetMapping("/adicionarPessoa/deletar/{id}")
    public String deletarPessoa(@PathVariable("id") long id){
        pessoaRepo.deleteById(id);
        return "redirect:/adicionarPessoa/listar";
    }

    @GetMapping("/adicionarPessoa/editar/{id}")
    public ModelAndView editarPessoa(@PathVariable("id") long id) throws Exception{
        Pessoa pessoa = pessoaRepo.findById(id).orElseThrow(() -> new Exception("Nada encontrado!"));
        ModelAndView mav = new ModelAndView("editarPessoa");
        mav.addObject("pessoa", pessoa);
        return mav;
    }

    @PostMapping("/adicionarPessoa/editar")
    public String editarSucesso(Pessoa pessoa){
        pessoaRepo.deleteById(pessoa.getId_pessoa());
        pessoaRepo.save(pessoa);
        return "redirect:/adicionarPessoa/listar";
    }

}