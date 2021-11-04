package br.com.mirante.referencia.repository;


import br.com.mirante.referencia.domain.Referencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ReferenciaRepositoryJpa implements ReferenciaRepository {


    @Autowired
    private EntityManager entityManager;

    @Override
    public void salvar(List<Referencia> referencias) {
        referencias.forEach(entityManager::persist);
    }
}
