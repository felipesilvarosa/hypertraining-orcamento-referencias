package br.com.mirante.referencia.repository;

import br.com.mirante.referencia.domain.ItemReferencia;

import java.util.List;

public interface ItemReferenciaRepository {
    void salvar(ItemReferencia item);

    void excluir(String codigo);

    List<ItemReferencia> listar();
}
