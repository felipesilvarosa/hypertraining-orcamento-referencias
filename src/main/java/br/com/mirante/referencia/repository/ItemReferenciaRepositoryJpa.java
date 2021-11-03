package br.com.mirante.referencia.repository;

import br.com.mirante.referencia.domain.ItemReferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ItemReferenciaRepositoryJpa implements ItemReferenciaRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void salvar(ItemReferencia item) {
        entityManager.merge(item);
    }

    @Override
    @Transactional
    public void excluir(String codigo) {
        entityManager
                .createQuery("delete from ItemReferencia i where i.codigo = :codigo")
                .setParameter("codigo", codigo)
                .executeUpdate();
    }

    @Override
    public List<ItemReferencia> listar() {
        return entityManager.createQuery("from ItemReferencia", ItemReferencia.class).getResultList();
    }
}
