package edu.unipe.services;

import javax.persistence.EntityManager;

import edu.unipe.bd.JPAUtil;
import edu.unipe.daos.UsuarioDAO;
import edu.unipe.entities.Usuario;

public class UsuarioService {

	private UsuarioDAO usuarioDAO;
	private EntityManager manager;

	public UsuarioService() {
	}
	
	public Usuario validaLogin(String login, String senha){
		manager = JPAUtil.getEntityManager();
		usuarioDAO = new UsuarioDAO(manager);
		return usuarioDAO.validaLogin(login,senha);
		
	}
//
//	public void inserir(Cliente cliente) throws Exception {
//		if (cliente.getNome() == null) {
//			throw new Exception("O nome do cliente é obrigatório");
//		}
//		try {
//			clienteDAO.inserir(cliente);
//			manager.getTransaction().commit();
//		} catch (Exception e) {
//			manager.getTransaction().rollback();
//		} finally {
//			manager.close();
//		}
//	}
}
