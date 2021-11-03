package br.com.mirante.referencia.service;

import br.com.mirante.referencia.domain.ItemReferencia;
import br.com.mirante.referencia.domain.Periodo;
import br.com.mirante.referencia.repository.ItemReferenciaRepository;
import br.com.mirante.referencia.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CadastrarItemReferenciaServico {

    @Autowired
    private ItemReferenciaRepository itemRepositorio;

    @Autowired
    private PeriodoRepository periodoRepositorio;

    @Transactional
    public void cadastrar(ItemReferencia item, List<Periodo> periodos){

        itemRepositorio.salvar(item);
        periodos.forEach(periodo -> periodo.setItem(item));
        periodoRepositorio.salvar(periodos);

    }
}
