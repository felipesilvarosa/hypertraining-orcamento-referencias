package br.com.mirante.referencia.service;

import br.com.mirante.referencia.domain.ItemReferencia;
import br.com.mirante.referencia.repository.ItemReferenciaRepository;
import br.com.mirante.referencia.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarItensServico {

    @Autowired
    private ItemReferenciaRepository repositorio;

    @Autowired
    private PeriodoRepository periodoRepository;

    public List<ItemReferencia> listarItens(){
        return repositorio.listar();
    }

}