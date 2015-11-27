package edu.unipe.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.unipe.entities.Usuario;
import edu.unipe.services.UsuarioService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(login.equals("") || senha.equals("")){
			response.sendRedirect("login.html");
			return;
		}
		
		UsuarioService usuarioService = new UsuarioService();
		
		Usuario usuario = usuarioService.validaLogin(login, senha);
		
		if(usuario == null){
			response.sendRedirect("login.html");
			return;
		}
		request.getSession().setAttribute("usuario", usuario);
		request.getSession().setMaxInactiveInterval(1000);
		response.sendRedirect("inicial.jsp");
		
	}

}
