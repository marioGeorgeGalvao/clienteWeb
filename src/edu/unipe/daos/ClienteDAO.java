package edu.unipe.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.unipe.entities.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente>{

	public ClienteDAO(EntityManager manager) {
		super(manager, Cliente.class);
	}

	public List<Cliente> buscarPorNome(String filtro) {
		String sql = "select c from Cliente c where upper(c.nome) like upper(:nome)";
		Query query = manager.createQuery(sql);
		query.setParameter("nome", "%"+filtro+"%");
		return query.getResultList();
	}
	
	
}
