package br.com.mirante.referencia.service;

import br.com.mirante.referencia.domain.Periodo;
import br.com.mirante.referencia.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarPeriodosServico {

    @Autowired
    private PeriodoRepository repositorio;

    public List<Periodo> listarPeriodos(){
        return repositorio.listar();
    }

}
