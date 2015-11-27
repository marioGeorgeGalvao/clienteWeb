package edu.unipe.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unipe.entities.Categoria;
import edu.unipe.services.ServicoCategoria;

/**
 * Servlet implementation class NovaCategoriaServlet2
 */
public class NovaCategoriaServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaCategoriaServlet2() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		if(request.getSession(false) == null){
			response.sendRedirect("login.html");
			return;
		}
	
	if(id != null){
		ServicoCategoria servicoCategoria = new ServicoCategoria();
		Categoria categoria = servicoCategoria.buscarPorId(new Long(id));
		request.setAttribute("categoria", categoria);
	}
	
	request.getRequestDispatcher("novaCategoria.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		
		if(request.getSession(false) == null){
			response.sendRedirect("login.html");
			return;
		}
		
		if(nome.equals("")){
			request.setAttribute("msgErro", "* O nome � obrigat�rio");
			request.getRequestDispatcher("novaCategoria.jsp").forward(request, response);
		}
				
		Categoria categoria = new Categoria();
		categoria.setNome(nome);
		
		ServicoCategoria  servicoCategoria = new ServicoCategoria();
		
		String id = request.getParameter("id");
		if(id != null && !id.equals("")){
			categoria.setId(new Long(id));
		}
		
		try {
			if(categoria.temIdValido()){
				servicoCategoria.editar(categoria);
			}else{
				servicoCategoria.adicionaCategoria(categoria);
			}
			
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			request.getRequestDispatcher("novaCategoria.jsp").forward(request, response);
		}
		
		response.sendRedirect("ListarCategoriaServlet");
	}

}
