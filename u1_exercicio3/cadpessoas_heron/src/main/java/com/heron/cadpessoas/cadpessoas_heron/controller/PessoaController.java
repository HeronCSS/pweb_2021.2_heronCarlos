package com.heron.cadpessoas.cadpessoas_heron.controller;

import com.heron.cadpessoas.cadpessoas_heron.model.Pessoa;
import com.heron.cadpessoas.cadpessoas_heron.repository.PessoaRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepo;

    @GetMapping("/")
    public String getInicio() {
        return "redirect:/public/index.html";
    }
    

    @GetMapping("/adicionarPessoa")
    public ModelAndView adicionarPessoa() {
        Pessoa pessoa = new Pessoa();
        ModelAndView mav = new ModelAndView("adicionarPessoa");
        mav.addObject("pessoa", pessoa);
        return mav;
    }


    @GetMapping("/listarPessoas")
    public ModelAndView pessoaAdicionada() {
        ModelAndView mav = new ModelAndView("listarPessoas");
        mav.addObject("pessoa", pessoaRepo.findAll());
        return mav;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarPessoa(@PathVariable("id") long id) {
        Pessoa pessoa = pessoaRepo.getById(id);
        ModelAndView mav = new ModelAndView("editarPessoa");
        mav.addObject("pessoaSalva", pessoa);
        return mav;
    }
    
    @PostMapping("/adicionarPessoa")
    public String adicionadaPessoa(Pessoa pessoa) {
        pessoaRepo.save(pessoa);
        return "redirect:/public/adicionadaComSucesso.html";
    }

    @PutMapping("/editar/{id}")
    public String editarSucesso(@PathVariable("id") long id, Pessoa pessoa){
        Pessoa pessoaAtualizar = pessoaRepo.getById(id);
        BeanUtils.copyProperties(pessoa, pessoaAtualizar, "id_pessoa");
        pessoaRepo.save(pessoaAtualizar);
        return "redirect:/listarPessoas";
    }

    @DeleteMapping("/adicionarPessoa/deletar/{id}")
    public String deletarPessoa(@PathVariable("id") long id) {
        pessoaRepo.deleteById(id);
        return "redirect:/listarPessoas";
    }

}