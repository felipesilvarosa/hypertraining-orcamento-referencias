package br.com.mirante.referencia.controller;

import br.com.mirante.referencia.domain.Produto;
import br.com.mirante.referencia.domain.ProdutoDB;
import br.com.mirante.referencia.domain.Referencia;
import br.com.mirante.referencia.service.CadastrarProdutoService;
import br.com.mirante.referencia.service.ListarProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private CadastrarProdutoService cadastrarProdutoService;

    @Autowired
    private ListarProdutoService listarProdutoService;

    @PostMapping
    public ProdutoDB cadastrarProduto(@RequestBody CadastrarProdutoRequest request){
        return cadastrarProdutoService.cadastrar(request.produto, request.referencias);
    }

    @GetMapping
    public Map<String, Produto> listarProdutos(){

        return listarProdutoService.listarProdutos();
    }
}

class CadastrarProdutoRequest{
    ProdutoDB produto;
    List<Referencia> referencias;

    public CadastrarProdutoRequest(ProdutoDB produto, List<Referencia> referencias) {
        this.produto = produto;
        this.referencias = referencias;
    }

    public ProdutoDB getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDB produto) {
        this.produto = produto;
    }

    public List<Referencia> getReferencias() {
        return referencias;
    }

    public void setReferencias(List<Referencia> referencias) {
        this.referencias = referencias;
    }
}