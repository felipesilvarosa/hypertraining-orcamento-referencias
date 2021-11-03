package br.com.mirante.referencia.service;

import br.com.mirante.referencia.repository.ItemReferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExcluirItemServico {

    @Autowired
    private ItemReferenciaRepository repositorio;

    public void excluirItem(String codigo) {
        repositorio.excluir(codigo);
    }

}
