package br.com.mirante.referencia.service;

import br.com.mirante.referencia.domain.Produto;
import br.com.mirante.referencia.domain.ProdutoDB;
import br.com.mirante.referencia.domain.Referencia;
import br.com.mirante.referencia.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ListarProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Map<String, Produto> listarProdutos(){

        List<ProdutoDB> produtosDb = produtoRepository.listar();

        Map<String, Produto> mapProdutos = new HashMap<>();

        for(ProdutoDB produtoDb : produtosDb){
            List<Referencia> referencias = produtoDb.getReferencias();
            for(Referencia referencia : referencias){
                mapProdutos.put
                        (referencia.getMes()+""+referencia.getAno()+""+produtoDb.getCodigo(),
                               new Produto(
                                        referencia.getOrigem(),
                                        produtoDb.getCodigo(),
                                        produtoDb.getDescricao(),
                                        produtoDb.getUnidadeMedida(),
                                        referencia.getValor()));
            }
        }
            return mapProdutos;
    }
}
