package com.heron.cadpessoas.cadpessoas_heron.config;

import com.heron.cadpessoas.cadpessoas_heron.model.Pessoa;
import com.heron.cadpessoas.cadpessoas_heron.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ComandosStartup implements CommandLineRunner{
    
    @Autowired
    PessoaRepository pessoaRepo;

    @Override
    public void run(String... args) throws Exception {
        gerarPessoas();
    }

    public void gerarPessoas(){
        if (pessoaRepo.findById(1L).isPresent()) {
            System.out.println("Três Pessoas Cadastradas!");
        } else {

        Pessoa pessoaH = new Pessoa();
        pessoaH.setId_pessoa(1L);
        pessoaH.setNome("Heron Carlos");
        pessoaH.setDataNascimento("27/02/2003");
        pessoaH.setEmail("heron11carlos@gmail.com");
        pessoaH.setSexo("Masculino");
        pessoaRepo.save(pessoaH);

        Pessoa pessoaD = new Pessoa();
        pessoaD.setId_pessoa(2L);
        pessoaD.setNome("Douglas Ryan");
        pessoaD.setDataNascimento("18/12/1998");
        pessoaD.setEmail("euSou_o_Dougras@gmail.com");
        pessoaD.setSexo("Masculino");
        pessoaRepo.save(pessoaD);

        Pessoa pessoaE = new Pessoa();
        pessoaE.setId_pessoa(3L);
        pessoaE.setNome("Equiton Gomes");
        pessoaE.setDataNascimento("20/04/1967");
        pessoaE.setEmail("kitinho_pika@gmail.com");
        pessoaE.setSexo("Não Informar");
        pessoaRepo.save(pessoaE);
        
        System.out.println("Três Pessoas Cadastradas!");

        }
    }
}
