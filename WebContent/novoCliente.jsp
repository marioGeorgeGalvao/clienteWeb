<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.unipe.entities.Cliente" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo cliente</title>
</head>
<body>

<h3>Cadastro de Clientes</h3> <br>
	<% 
		String mensagem = (String) request.getAttribute("msgErro");
		if(mensagem != null){
			out.println(mensagem);
		}
		Cliente cliente = (Cliente) request.getAttribute("cliente");
	%>
	
	<br />
	<form action="formularioCadastro" method="post" >
		<input type="hidden" name="id" value="<%=cliente != null ? cliente.getId() : ""%>" />
			Nome:<input type="text" name="nome" value="<%=cliente != null ? cliente.getNome() : ""%>" /><br />
			Login:<input type="text" name="login" value="<%=cliente != null ? cliente.getLogin() : ""%>" /><br />
			Senha:<input type="password" name="senha" value="<%=cliente != null ? cliente.getSenha() : ""%>" /><br />
			Rua:<input type="text" name="rua" value="<%=cliente != null ? cliente.getEndereco().getRua() : ""%>" /><br />
			Cep:<input type="text" name="cep" value="<%=cliente != null ? cliente.getEndereco().getCep() : ""%>"/><br />
			Bairro:<input type="text" name="bairro" value="<%=cliente != null ? cliente.getEndereco().getBairro() : ""%>" /><br />
		<input type="submit" value="salvar"/>
	</form>

</body>
</html>