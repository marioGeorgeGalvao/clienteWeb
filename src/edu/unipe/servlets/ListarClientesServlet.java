package edu.unipe.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unipe.entities.Cliente;
import edu.unipe.services.ClienteService;

public class ListarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession(false) == null){	
			response.sendRedirect("login.html");
			return;
		}
		
		String filtro = request.getParameter("filtro");
		
		ClienteService clienteService = new ClienteService();
		List<Cliente> clientes = new ArrayList<Cliente>();
		if(filtro != null && !filtro.equals("")){
			clientes = clienteService.buscarPorNome(filtro);
		}
		else{
			clientes = clienteService.listar();
		}
		
		request.setAttribute("clientes", clientes);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarClientes.jsp");
		requestDispatcher.forward(request, response);
		
	}

}