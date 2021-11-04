package br.com.mirante.referencia.repository;

import br.com.mirante.referencia.domain.Referencia;

import java.util.List;

public interface ReferenciaRepository {
    void salvar(List<Referencia> referencias);
}
