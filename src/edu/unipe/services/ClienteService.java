package edu.unipe.services;

import java.util.List;

import javax.persistence.EntityManager;

import edu.unipe.bd.JPAUtil;
import edu.unipe.daos.ClienteDAO;
import edu.unipe.entities.Cliente;

public class ClienteService {

	private ClienteDAO clienteDAO;
	private EntityManager manager;

	public ClienteService() {

	}

	public void inserir(Cliente cliente) throws Exception {
		manager = JPAUtil.getEntityManager();
		clienteDAO = new ClienteDAO(manager);
		if (cliente.getNome() == null) {
			throw new Exception("O nome do cliente é obrigatório");
		}
		try {
			manager.getTransaction().begin();
			clienteDAO.inserir(cliente);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}
	
	public void atualizar(Cliente cliente) throws Exception {
		manager = JPAUtil.getEntityManager();
		clienteDAO = new ClienteDAO(manager);
		if (cliente.getNome() == null) {
			throw new Exception("O nome do cliente é obrigatório");
		}
		try {
			manager.getTransaction().begin();
			clienteDAO.atualizar(cliente);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public Cliente buscarPorId(Long id) {
		Cliente cliente = null;
		manager = JPAUtil.getEntityManager();
		clienteDAO = new ClienteDAO(manager);
		try {
			manager.getTransaction().begin();
			cliente = clienteDAO.buscarPorID(id);
		} finally {
			manager.close();
		}
		return cliente;
	}

	public void remover(Cliente cliente) throws Exception {
		manager = JPAUtil.getEntityManager();
		clienteDAO = new ClienteDAO(manager);
		try {
			manager.getTransaction().begin();
			clienteDAO.excluir(cliente);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public List<Cliente> listar() {
		manager = JPAUtil.getEntityManager();
		clienteDAO = new ClienteDAO(manager);
		return clienteDAO.listar();

	}

	public List<Cliente> buscarPorNome(String filtro) {
		manager = JPAUtil.getEntityManager();
		clienteDAO = new ClienteDAO(manager);
		return clienteDAO.buscarPorNome(filtro);

	}
}
