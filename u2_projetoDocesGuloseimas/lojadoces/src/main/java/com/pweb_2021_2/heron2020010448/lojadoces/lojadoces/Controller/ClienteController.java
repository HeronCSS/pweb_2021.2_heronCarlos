package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model.Pedido;
import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model.Pessoa;
import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model.Produto;
import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Repositories.DependentesRepository;
import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Repositories.PedidoRepository;
import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Repositories.PessoaRepository;
import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Repositories.ProdutoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping
public class ClienteController {
    
    @Autowired
    PessoaRepository pessoaRepo;

    @Autowired
    ProdutoRepository produtoRepo;

    @Autowired
    PedidoRepository pedidoRepo;

    @Autowired
    DependentesRepository dependeRepo;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        List<Produto> prodList = new ArrayList<>();
        prodList = produtoRepo.findAll();
        List<String> prodLinks = new ArrayList<>();
        for (int i = 0; i < prodList.size(); i++) {
            prodLinks.add(prodList.get(i).getLinkImg());
        }

        //TODO: Fazer a foto da careca de Xico
        //TODO: Fazer um metodo em ProdutoService que pega os 5 produtos mais vendidos com Dois FOR aninhado e comparando o valor.
        mav.addObject("prod", prodLinks);
        return mav;
    }

    @GetMapping("/clientes")
    public ModelAndView getClientes(){
        ModelAndView mav = new ModelAndView("clientes");
        Pessoa pessoa = new Pessoa();
        mav.addObject("pessoa", pessoa);
        mav.addObject("pessoas", pessoaRepo.findAll());
        return mav;
    }

    @PostMapping("/clientes/cadastrar")
    public String postClientes(Pessoa cliente){
        pessoaRepo.save(cliente);
        return "redirect:/clientes";
    }

    @PutMapping("/clientes/atualizar/{id}")
    public String putCliente(@PathVariable Long id, Pessoa cliente) throws Exception{
        Pessoa newCliente = pessoaRepo.findById(id).orElseThrow(()-> new Exception("Não encontrado!"));
        BeanUtils.copyProperties(cliente, newCliente, "id");
        pessoaRepo.save(newCliente);
        return "redirect:/clientes";
    }

    @DeleteMapping("/clientes/delete/{id}")
    public String deleteCliente(@PathVariable Long id){
        pessoaRepo.deleteById(id);
        return "redirect:/clientes";
    }

    /* Produtos */

    @GetMapping("/produtos")
    public ModelAndView getProdutos() {
        ModelAndView mav = new ModelAndView("produtos");
        Produto produto = new Produto();
        mav.addObject("produto", produto);
        mav.addObject("produtos", produtoRepo.findAll());
        return mav;
    }
    
    @PostMapping("/produtos/cadastrar")
    public String postProdutos(Produto produto) throws Exception{
        produto.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        produtoRepo.save(produto);
        return "redirect:/produtos";
    }

    @PutMapping("/produtos/atualizar/{id}")
    public String putProduto(@PathVariable Long id, Produto produto) throws Exception{
        Produto newProduto = produtoRepo.findById(id).orElseThrow(()-> new Exception("Não encontrado!"));
        BeanUtils.copyProperties(produto, newProduto, "id");
        produtoRepo.save(newProduto);
        return "redirect:/produtos";
    }

    @DeleteMapping("/produtos/delete/{id}")
    public String deleteProduto(@PathVariable("id") Long id){
        produtoRepo.deleteById(id);
        return "redirect:/produtos";
    }

    /* Pedidos */

    @GetMapping("/meusPedidos")
    public ModelAndView getPedidos(){
        ModelAndView mav = new ModelAndView("pedidos");
        Pedido pedido = new Pedido();
        mav.addObject("pedido", pedido);
        return mav;
    }

    @PostMapping("/meusPedidos/cadastrar")
    public String postPedidos(Pedido pedido){
        pedidoRepo.save(pedido);
        return "redirect:/meusPedidos";
    }

    @PutMapping("/meusPedidos/atualizar/{id}")
    public String putPedido(@PathVariable Long id, Pedido pedido) throws Exception{
        Pedido newPedido = pedidoRepo.findById(id).orElseThrow(()-> new Exception("Não encontrado!"));
        BeanUtils.copyProperties(pedido, newPedido, "id");
        pedidoRepo.save(newPedido);
        return "redirect:/meusPedidos";
    }

    @DeleteMapping("/meusPedidos/remover/{id}")
    public String deletePedido(@PathVariable Long id){
        pedidoRepo.deleteById(id);
        return "redirect:/meusPedidos";
    }


}
