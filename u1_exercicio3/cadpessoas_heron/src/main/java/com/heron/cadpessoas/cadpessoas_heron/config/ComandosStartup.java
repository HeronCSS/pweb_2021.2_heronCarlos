package com.heron.cadpessoas.cadpessoas_heron.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Stream;

import com.heron.cadpessoas.cadpessoas_heron.model.Escolha;
import com.heron.cadpessoas.cadpessoas_heron.model.Pessoa;
import com.heron.cadpessoas.cadpessoas_heron.repository.EscolhaRepository;
import com.heron.cadpessoas.cadpessoas_heron.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ComandosStartup implements CommandLineRunner {

    @Autowired
    PessoaRepository pessoaRepo;

    @Autowired
    EscolhaRepository escolhaRepo;

    @Override
    public void run(String... args) throws Exception {
        gerarPessoas();
        gerarEscolhas();
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
            pessoaH.setApelido("Lazy Master");
            pessoaH.setSequenciaDecisao(1L);
            pessoaRepo.save(pessoaH);

            Pessoa pessoaD = new Pessoa();
            pessoaD.setId_pessoa(2L);
            pessoaD.setNome("Douglas Ryan");
            pessoaD.setDataNascimento(new SimpleDateFormat("dd/mm/yyyy").parse("20/04/1998"));
            pessoaD.setEmail("euSou_o_Dougras@gmail.com");
            pessoaD.setSexo("Masculino");
            pessoaH.setApelido("Coxinha");
            pessoaH.setSequenciaDecisao(1L);
            pessoaRepo.save(pessoaD);

            Pessoa pessoaE = new Pessoa();
            pessoaE.setId_pessoa(3L);
            pessoaE.setNome("Equiton Gomes");
            pessoaE.setDataNascimento(new SimpleDateFormat("dd/mm/yyyy").parse("26/04/2002"));
            pessoaE.setEmail("kitinho_gomes@gmail.com");
            pessoaE.setSexo("Não Informar");
            pessoaH.setApelido("Kitin");
            pessoaH.setSequenciaDecisao(1L);
            pessoaRepo.save(pessoaE);

            System.out.println("Três Pessoas Cadastradas!");

        }
    }

    public void gerarEscolhas(){
        HashMap<String, Long> map = new LinkedHashMap<>();
        map.put("a) Um vampiro mal", 2L);
        map.put("b) Um vampiro que era mal e ficou bom", 3L);
        map.put("c) Um vampiro bom", 4L);
        map.put("d) Um vampiro bom que virou mal", 5L);

        escolhaRepo.save(new Escolha(1L,"Era uma vez um vampiro chamado {player} que estava a navegar nos mares da pentescopéia. Um homem então lhe abordou, este homem não parecia tanto um homem, mas sim uma criatura, talvez seu nível de maldade acima do próprio vampiro. \n\nEste é o início de uma história.\n\nEscolha sua história de fundo:",
        map));
        map.clear();

        map.put("a) Dinheiro", 6L);
        map.put("b) Fama", 7L);
        map.put("c) Poder", 8L);
        map.put("d) Vingança", 9L);
        escolhaRepo.save(new Escolha(2L, "A criatura olha para o Vampiro e diz: “O que você deseja, eu posso te oferecer, mas terá um preço a pagar.”\n\nEscolha o que você deseja:", map));
        map.clear();

        map.put("a) Duque de San Giorgino, Giovane Petorino", 10L);
        map.put("b) Visconde de Litonia, Sir Cobain", 11L);
        map.put("c) Cavaleiro da Távola, Lionidas Sparti", 12L);
        map.put("d) Diretor da Academia Mágica, Kiton Gumus", 13L);

        escolhaRepo.save(new Escolha(6L, "Criatura - \"Hahaha... o que todos desejam, no final. Eu te darei dinheiro, te farei o mais rico destas terras. Em troca, você terá que matar 3 pessoas.\"\n\nEscolha quem você deseja matar primeiro:", map));

        System.out.println("Escolhas Cadastradas!");
    }
}
