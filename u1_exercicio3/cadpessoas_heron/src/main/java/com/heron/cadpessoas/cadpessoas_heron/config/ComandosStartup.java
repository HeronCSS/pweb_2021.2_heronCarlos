package com.heron.cadpessoas.cadpessoas_heron.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.heron.cadpessoas.cadpessoas_heron.model.Pessoa;
import com.heron.cadpessoas.cadpessoas_heron.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ComandosStartup implements CommandLineRunner {

    @Autowired
    PessoaRepository pessoaRepo;

    @Override
    public void run(String... args) throws Exception {
        gerarPessoas();
        System.out.println("Running...");
    }

    public void gerarPessoas() throws ParseException {
        if (pessoaRepo.findById(1L).isPresent()) {
            System.out.println("Três Pessoas Cadastradas!");
        } else {
            Pessoa pessoaH = new Pessoa();
            pessoaH.setId_pessoa(1L);
            pessoaH.setNome("Heron Carlos");
            pessoaH.setDataNascimento(new SimpleDateFormat("dd/mm/yyyy").parse("27/01/2003"));
            pessoaH.setEmail("heron11carlos@gmail.com");
            pessoaH.setSexo("Masculino");
            pessoaRepo.save(pessoaH);

            Pessoa pessoaD = new Pessoa();
            pessoaD.setId_pessoa(2L);
            pessoaD.setNome("Douglas Ryan");
            pessoaD.setDataNascimento(new SimpleDateFormat("dd/mm/yyyy").parse("20/04/1998"));
            pessoaD.setEmail("euSou_o_Dougras@gmail.com");
            pessoaD.setSexo("Masculino");
            pessoaRepo.save(pessoaD);

            Pessoa pessoaE = new Pessoa();
            pessoaE.setId_pessoa(3L);
            pessoaE.setNome("Equiton Gomes");
            pessoaE.setDataNascimento(new SimpleDateFormat("dd/mm/yyyy").parse("26/04/2002"));
            pessoaE.setEmail("kitinho_pika@gmail.com");
            pessoaE.setSexo("Não Informar");
            pessoaRepo.save(pessoaE);

            System.out.println("Três Pessoas Cadastradas!");

        }
    }
}
