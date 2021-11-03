package br.com.mirante.referencia.repository;

import br.com.mirante.referencia.domain.Periodo;

import java.util.List;

public interface PeriodoRepository {
    void salvar(List<Periodo> periodos);

    List<Periodo> listar();
}
