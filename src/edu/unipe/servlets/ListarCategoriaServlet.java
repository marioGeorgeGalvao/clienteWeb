package edu.unipe.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unipe.entities.Categoria;
import edu.unipe.services.ServicoCategoria;

public class ListarCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession(false) == null){	
			response.sendRedirect("login.html");
			return;
		}
		
		String filtro = request.getParameter("filtro");
		
		ServicoCategoria servicoCategoria = new ServicoCategoria();
		List<Categoria> categorias = new ArrayList<Categoria>();
		if(filtro != null && !filtro.equals("")){
			categorias = servicoCategoria.buscarPorNome(filtro);
		}
		else{
			categorias = servicoCategoria.listar();
		}
		
		request.setAttribute("categorias", categorias);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarCategorias.jsp");
		requestDispatcher.forward(request, response);
		
	}

}