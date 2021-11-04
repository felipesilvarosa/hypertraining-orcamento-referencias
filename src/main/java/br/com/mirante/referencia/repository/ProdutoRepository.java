package br.com.mirante.referencia.repository;

import br.com.mirante.referencia.domain.ProdutoDB;

import java.util.List;

public interface ProdutoRepository {
     void salvar(ProdutoDB produto);

    List<ProdutoDB> listar();
}
