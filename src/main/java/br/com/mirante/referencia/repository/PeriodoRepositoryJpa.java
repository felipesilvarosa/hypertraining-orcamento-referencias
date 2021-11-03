package br.com.mirante.referencia.repository;

import br.com.mirante.referencia.domain.ItemReferencia;
import br.com.mirante.referencia.domain.Periodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PeriodoRepositoryJpa implements PeriodoRepository {

    @Autowired
    private  EntityManager entityManager;

    @Override
    public void salvar(List<Periodo> periodos) {
        periodos.forEach(entityManager::merge);
    }

    @Override
    public List<Periodo> listar() {
        return entityManager.createQuery("from Periodo", Periodo.class).getResultList();
    }
}
