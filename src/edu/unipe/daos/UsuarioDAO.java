package edu.unipe.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.unipe.entities.Usuario;

public class UsuarioDAO extends AbstractDAO<Usuario>{

	public UsuarioDAO(EntityManager manager) {
		super(manager, Usuario.class);
	}

	public Usuario validaLogin(String login, String senha) {
		String s = "select u from Usuario u where u.login = :login and u.senha = :senha";
		Query query = manager.createQuery(s);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		List<Usuario> usuarios = query.getResultList();
		
		if(!usuarios.isEmpty()){
			return usuarios.get(0);
		}
		return null;
	}

}
