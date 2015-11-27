package edu.unipe.bd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	static EntityManagerFactory fac = Persistence.createEntityManagerFactory("cadastroCliente");

	public static EntityManager getEntityManager(){
		return fac.createEntityManager();
	}
}

