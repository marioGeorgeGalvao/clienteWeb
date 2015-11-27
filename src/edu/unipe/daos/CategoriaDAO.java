package edu.unipe.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import edu.unipe.entities.Categoria;

public class CategoriaDAO extends AbstractDAO<Categoria> {

    public CategoriaDAO(EntityManager manager) {
        super(manager, Categoria.class);
    }
    
    public List<Categoria> buscarPorNome(String filtro) {
		String sql = "select c from Cliente c where upper(c.nome) like upper(:nome)";
		Query query = manager.createQuery(sql);
		query.setParameter("nome", "%"+filtro+"%");
		return query.getResultList();
	}

}
