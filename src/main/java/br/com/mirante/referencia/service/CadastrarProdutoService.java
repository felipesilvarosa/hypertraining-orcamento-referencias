package br.com.mirante.referencia.service;

import br.com.mirante.referencia.domain.ProdutoDB;
import br.com.mirante.referencia.domain.Referencia;
import br.com.mirante.referencia.repository.ReferenciaRepository;
import br.com.mirante.referencia.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CadastrarProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ReferenciaRepository referenciaRepository;

    @Transactional
    public ProdutoDB cadastrar (ProdutoDB produto, List<Referencia> referencias){


        produto.setReferencias(referencias);
        produtoRepository.salvar(produto);
        referencias.forEach(referencia -> referencia.setProduto(produto));
        referenciaRepository.salvar(referencias);
        return produto;
    }
}
