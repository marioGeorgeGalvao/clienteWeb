package edu.unipe.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unipe.entities.Cliente;
import edu.unipe.services.ClienteService;


public class RemoverClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Cliente cliente = new Cliente();
		cliente.setId(new Long(id));
		ClienteService clienteService = new ClienteService();
		
		try {
			clienteService.remover(cliente);
		} catch (Exception e) {
			request.getRequestDispatcher("listarClientes").forward(request, response);
		}
		request.getRequestDispatcher("listarClientes").forward(request, response);
	}
}
