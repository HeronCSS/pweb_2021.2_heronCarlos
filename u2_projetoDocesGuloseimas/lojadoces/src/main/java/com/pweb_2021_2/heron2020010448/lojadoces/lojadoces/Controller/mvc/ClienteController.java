package com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Controller.mvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.pweb_2021_2.heron2020010448.lojadoces.lojadoces.Model.Dependentes;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.Data;

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
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        List<Produto> prodList = new ArrayList<>();
        prodList = produtoRepo.findAll();
        List<String> prodLinks = new ArrayList<>();
        for (int i = 0; i < prodList.size(); i++) {
            prodLinks.add(prodList.get(i).getLinkImg());
        }

        // TODO: Fazer um metodo em ProdutoService que pega os 5 produtos mais vendidos
        // com Dois FOR aninhado e comparando o valor.
        mav.addObject("prod", prodLinks);
        return mav;
    }

    @GetMapping("/clientes")
    public ModelAndView getClientes() {
        ModelAndView mav = new ModelAndView("clientes");
        Pessoa pessoa = new Pessoa();
        mav.addObject("pessoa", pessoa);
        mav.addObject("pessoas", pessoaRepo.findAll());
        return mav;
    }

    @GetMapping("/clientes/info/{id}")
    public ModelAndView getPedidos(@PathVariable("id") Long id) throws Exception {
        ModelAndView mav = new ModelAndView("cliente-info");
        Pessoa cliente = pessoaRepo.findById(id).orElseThrow(() -> new Exception());
        mav.addObject("cliente", cliente);
        mav.addObject("dependentes", cliente.getDependentes());
        mav.addObject("pedido", cliente.getPedidos());
        return mav;
    }

    @PostMapping("/clientes/cadastrar")
    public String postClientes(Pessoa cliente) {
        pessoaRepo.save(cliente);
        return "redirect:/clientes";
    }

    @PutMapping("/clientes/atualizar/{id}")
    public String putCliente(@PathVariable Long id, Pessoa cliente) throws Exception {
        Pessoa newCliente = pessoaRepo.findById(id).orElseThrow(() -> new Exception("Não encontrado!"));
        BeanUtils.copyProperties(cliente, newCliente, "idPessoa");
        pessoaRepo.save(newCliente);
        return "redirect:/clientes";
    }

    @DeleteMapping("/clientes/delete/{id}")
    public String deleteCliente(@PathVariable Long id) {
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
    public String postProdutos(Produto produto) throws Exception {
        produto.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        produtoRepo.save(produto);
        return "redirect:/produtos";
    }

    @PutMapping("/produtos/atualizar/{id}")
    public String putProduto(@PathVariable Long id, Produto produto) throws Exception {
        Produto newProduto = produtoRepo.findById(id).orElseThrow(() -> new Exception("Não encontrado!"));
        BeanUtils.copyProperties(produto, newProduto, "id");
        produtoRepo.save(newProduto);
        return "redirect:/produtos";
    }

    @DeleteMapping("/produtos/delete/{id}")
    public String deleteProduto(@PathVariable("id") Long id) {
        produtoRepo.deleteById(id);
        return "redirect:/produtos";
    }

    /* Pedidos */

    @GetMapping("/cliente/{id}/pedidos")
    public String pedidos(@PathVariable Long id) throws Exception {
        Pessoa cliente = pessoaRepo.findById(id).orElseThrow(() -> new Exception());
        int index = cliente.getPedidos().size();
        cliente.getPedidos().add(new Pedido());
        pessoaRepo.save(cliente);
        return "redirect:/cliente/"+id+"/pedidos/"+cliente.getPedidos().get(index).getId();
        /*
         * ModelAndView mav = new ModelAndView("pedidos");
         * mav.addObject("idCliente", id);
         * mav.addObject("produtos", produtoRepo.findAll());
         * mav.addObject("produtoID", new Produto());
         * return mav;
         */
    }

    @GetMapping("/cliente/{idCliente}/pedidos/{id}")
    public ModelAndView adicionarProduto(@PathVariable("idCliente") Long idCliente, @PathVariable("id") Long id) throws Exception {
        ModelAndView mav = new ModelAndView("pedidos");
        Pedido pedido = pedidoRepo.findById(id).orElseThrow(()-> new Exception("Pedido deu errado!"));
        mav.addObject("idCliente", idCliente);
        mav.addObject("produtosList", pedido.getProdutos());
        mav.addObject("pedido", pedido);
        mav.addObject("product", new Produto());
        mav.addObject("produtos", produtoRepo.findAll());
        return mav;
    }

    @GetMapping("/cliente/{idCliente}/pedidos/{id}/adicionar/")
    public String adicionarPedido(@PathVariable(name = "idCliente") Long idCliente, @PathVariable(name = "id") Long id, Produto produtoF) throws Exception {
        Pedido pedido = pedidoRepo.findById(id).orElseThrow(()-> new Exception());
        Long idProduto = produtoF.getId();
        Produto produto = produtoRepo.findById(idProduto).orElseThrow(()->new Exception());
        produto.setVezesVendido(+1);
        pedido.getProdutos().add(produto);
        Double valorTotalPago = 0.0;
        Double valorTotalProduto = 0.0;
        for (int i = 0; i < pedido.getProdutos().size(); i++) {
            valorTotalPago += pedido.getProdutos().get(i).getPrecoVenda();
            valorTotalProduto += pedido.getProdutos().get(i).getPrecoVenda();
        }
        valorTotalPago += (valorTotalPago*(12.5))/100;
        pedido.setValorTotalPago(valorTotalPago);
        pedido.setValorTotalProduto(valorTotalProduto);
        pedidoRepo.save(pedido);
        return "redirect:/cliente/"+idCliente+"/pedidos/"+id;
    }

    @GetMapping("/cliente/{idCliente}/pedidos/{id}/remover/{idProduto}")
    public String removerPedido(@PathVariable("idCliente") Long idCliente, @PathVariable("id") Long id, @PathVariable("idProduto") Long idProduto) throws Exception{
        Pedido pedido = pedidoRepo.findById(id).orElseThrow(()-> new Exception());
        Produto produto = produtoRepo.findById(idProduto).orElseThrow(()-> new Exception());
        produto.setVezesVendido(-1);
        pedido.getProdutos().remove(produto);
        pedidoRepo.save(pedido);
        return "redirect:/cliente/"+idCliente+"/pedidos/"+id;
    }

    @PostMapping("/cliente/{idCliente}/pedidos/finalizar/{id}")
    public String postPedidos(@PathVariable("idCliente") Long idCliente, @PathVariable("id") Long id, Pedido pedido) throws Exception {
        Pedido newPedido = pedidoRepo.findById(id).orElseThrow(()-> new Exception());
        System.out.println(newPedido.getProdutos().get(0).getNomeProduto());
        newPedido.setCodigoCartao(pedido.getCodigoCartao());
        newPedido.setNumeroCartao(pedido.getNumeroCartao());
        newPedido.setFormaPagamento(pedido.getFormaPagamento());
        newPedido.setDataDaVenda(new Date());
        pedidoRepo.save(newPedido);
        return "redirect:/clientes/info/"+idCliente;
    }

    @GetMapping("/cliente/{idCliente}/pedidos/info/{id}")
    public ModelAndView seePedido(@PathVariable("idCliente") Long idCliente, @PathVariable("id") Long id) throws Exception {
        ModelAndView mav = new ModelAndView("pedidos-info");
        System.out.println(pedidoRepo.findById(id).orElseThrow(() -> new Exception("Não encontrado!")).getProdutos().get(0).getNomeProduto());
        mav.addObject("pedido", pedidoRepo.findById(id).orElseThrow(() -> new Exception("Não encontrado!")));
        mav.addObject("produtos", pedidoRepo.findById(id).orElseThrow(() -> new Exception("Não encontrado!")).getProdutos());
        return mav;
    }

    @DeleteMapping("/meusPedidos/remover/{id}")
    public String deletePedido(@PathVariable Long id) {
        pedidoRepo.deleteById(id);
        return "redirect:/meusPedidos";
    }

    //Dependentes

    @GetMapping("/cliente/{id}/dependentes")
    public ModelAndView dependentes(@PathVariable Long id) throws Exception{
        ModelAndView mav = new ModelAndView("dependentes");
        Pessoa cliente = pessoaRepo.findById(id).orElseThrow(()-> new Exception());
        cliente.getDependentes().add(new Dependentes());
        int index = cliente.getDependentes().size()-1;
        mav.addObject("dependente", cliente.getDependentes().get(index));
        mav.addObject("id", id);
        return mav;
    }

    @PostMapping("/cliente/{id}/dependentes")
    public String postDependente(@PathVariable Long id, Dependentes dependente) throws Exception{
        Pessoa cliente = pessoaRepo.findById(id).orElseThrow(()-> new Exception());
        cliente.getDependentes().add(dependente);
        pessoaRepo.save(cliente);
        return "redirect:/clientes/info/"+id;
    }

    @DeleteMapping("/cliente/{idCliente}/dependentes/delete/{id}")
    public String deleteDependente(@PathVariable("idCliente") Long idCliente, @PathVariable("id") Long id) throws Exception{
        Pessoa cliente = pessoaRepo.findById(idCliente).orElseThrow(()-> new Exception());
        cliente.getDependentes().remove(dependeRepo.findById(id).orElseThrow(()-> new Exception()));
        pessoaRepo.save(cliente);
        return "redirect:/clientes/info/"+idCliente;
    }

    @GetMapping("/cliente/{idCliente}/dependentes/editar/{id}")
    public ModelAndView editarDependentes(@PathVariable("idCliente") Long idCliente, @PathVariable("id") Long id) throws Exception{
        ModelAndView mav = new ModelAndView("dependentes");
        mav.addObject("dependente2", dependeRepo.findById(id).orElseThrow(()-> new Exception()));
        mav.addObject("id", idCliente);
        return mav;
    }

    @PutMapping("/cliente/{idCliente}/dependentes/editar/{id}")
    public String editarDependente(@PathVariable("idCliente") Long idCliente, @PathVariable("id") Long id, Dependentes dependente) throws Exception{
        Dependentes newDependente = dependeRepo.findById(id).orElseThrow(()-> new Exception());
        BeanUtils.copyProperties(dependente, newDependente, "id");
        dependeRepo.save(newDependente);
        return "redirect:/clientes/info/"+idCliente;
    }

}
