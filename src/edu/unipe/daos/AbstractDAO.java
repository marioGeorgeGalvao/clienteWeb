package edu.unipe.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.unipe.entities.AbstractEntity;
import edu.unipe.entities.Cliente;

public class AbstractDAO<T extends AbstractEntity> {
	
	protected EntityManager manager;
	private Class<T> classe;
	
	public AbstractDAO(EntityManager manager, Class<T> classe) {
		this.manager = manager;
		this.classe = classe;
		
	}

	public void inserir(T entidade) {
		manager.persist(entidade);
	}

	public void atualizar(T entidade) {
		manager.merge(entidade);
	}

	public void excluir(T entidade) {
		entidade = manager.find(classe, entidade.getId());
		manager.remove(entidade);
	}
	
	public T buscarPorID(Long id) {
		return manager.find(classe, id);
	}
	
	public List<T> listar() {
		Query query = manager.createQuery("select e from "+classe.getSimpleName()+" e");
		return query.getResultList();
	}

}
