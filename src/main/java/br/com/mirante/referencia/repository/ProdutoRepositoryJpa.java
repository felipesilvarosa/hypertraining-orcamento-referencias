package br.com.mirante.referencia.repository;

import br.com.mirante.referencia.domain.Produto;
import br.com.mirante.referencia.domain.ProdutoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProdutoRepositoryJpa implements ProdutoRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void salvar(ProdutoDB produto) {
        entityManager.persist(produto);
    }

    @Override
    public List<ProdutoDB> listar() {
        return entityManager.createQuery("from ProdutoDB", ProdutoDB.class).getResultList();
    }
}
