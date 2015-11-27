package edu.unipe.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unipe.entities.Cliente;
import edu.unipe.entities.Endereco;
import edu.unipe.services.ClienteService;

/**
 * Servlet implementation class NovoClienteServlet
 */
public class NovoClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovoClienteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		
			if(request.getSession(false) == null){
				response.sendRedirect("login.html");
				return;
			}
		
		if(id != null){
			ClienteService clienteService = new ClienteService();
			Cliente cliente = clienteService.buscarPorId(new Long(id));
			request.setAttribute("cliente", cliente);
		}
		
		request.getRequestDispatcher("novoCliente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");		
		if(request.getSession(false) == null){
			response.sendRedirect("login.html");
			return;
		}
		
		if(nome.equals("")){
			request.setAttribute("msgErro", "* O nome � obrigat�rio");
			request.getRequestDispatcher("novoCliente.jsp").forward(request, response);
		}
		String rua = request.getParameter("rua");
		String cep = request.getParameter("cep");
		String bairro = request.getParameter("bairro");
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setSenha(senha);
		cliente.setLogin(login);
		cliente.setEndereco(new Endereco());
		cliente.getEndereco().setRua(rua);
		cliente.getEndereco().setCep(cep);
		cliente.getEndereco().setBairro(bairro);
		
		ClienteService  clienteService = new ClienteService();
		
		String id = request.getParameter("id");
		if(id != null && !id.equals("")){
			cliente.setId(new Long(id));
		}
		
		try {
			if(cliente.temIdValido()){
				clienteService.atualizar(cliente);
			}else{
				clienteService.inserir(cliente);
			}
			
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			request.getRequestDispatcher("novoCliente.jsp").forward(request, response);
		}
		
		response.sendRedirect("listarClientes");
		
				
		
	}

}
