package edu.unipe.services;

import edu.unipe.daos.CategoriaDAO;
import edu.unipe.daos.ClienteDAO;
import edu.unipe.entities.Categoria;
import edu.unipe.entities.Cliente;
import edu.unipe.bd.JPAUtil;

import javax.persistence.EntityManager;

import java.util.List;

public class ServicoCategoria {

    private CategoriaDAO categoriaDAO;
    private EntityManager manager;

    public ServicoCategoria() {
    }

    public void adicionaCategoria(Categoria categoria){
        manager = JPAUtil.getEntityManager();
        categoriaDAO = new CategoriaDAO(manager);

        try {
            manager.getTransaction().begin();
            categoriaDAO.inserir(categoria);
            manager.getTransaction().commit();
        } catch (Exception e){
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }

    public List<Categoria> listar(){
        manager = JPAUtil.getEntityManager();
        categoriaDAO = new CategoriaDAO(manager);

        return categoriaDAO.listar();
    }
    
    public Categoria buscarPorId(Long id) {
		Categoria categoria = null;
		manager = JPAUtil.getEntityManager();
		categoriaDAO = new CategoriaDAO(manager);
		try {
			manager.getTransaction().begin();
			categoria = categoriaDAO.buscarPorID(id);
		} finally {
			manager.close();
		}
		return categoria;
	}
    
    public void remover(Categoria categoria){
        manager = JPAUtil.getEntityManager();
        categoriaDAO = new CategoriaDAO(manager);

        try{
            manager.getTransaction().begin();
            categoriaDAO.excluir(categoria);
            manager.getTransaction().commit();
        } catch (Exception e){
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }

    public void editar(Categoria categoria){
        manager = JPAUtil.getEntityManager();
        categoriaDAO = new CategoriaDAO(manager);

        try{
            manager.getTransaction().begin();
            categoriaDAO.atualizar(categoria);
            manager.getTransaction().commit();
        } catch (Exception e ){
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }
    
    public List<Categoria> buscarPorNome(String filtro) {
		manager = JPAUtil.getEntityManager();
		categoriaDAO = new CategoriaDAO(manager);
		return categoriaDAO.buscarPorNome(filtro);
	}
}
