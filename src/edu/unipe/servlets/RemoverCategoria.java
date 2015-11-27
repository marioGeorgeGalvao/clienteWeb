package edu.unipe.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unipe.entities.Categoria;
import edu.unipe.services.ServicoCategoria;


public class RemoverCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Categoria categoria = new Categoria();
		categoria.setId(new Long(id));
		ServicoCategoria servicoCategoria = new ServicoCategoria();
		
		try {
			servicoCategoria.remover(categoria);
		} catch (Exception e) {
			request.getRequestDispatcher("ListarCategoriaServlet").forward(request, response);
		}
		request.getRequestDispatcher("ListarCategoriaServlet").forward(request, response);
	}
}
