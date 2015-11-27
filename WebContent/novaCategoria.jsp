<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.unipe.entities.Categoria" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Categorias</title>
</head>
<body>

<h3>Cadastro de Categorias</h3> <br>

<% 
		String mensagem = (String) request.getAttribute("msgErro");
		if(mensagem != null){
			out.println(mensagem);
		}
		Categoria categoria = (Categoria) request.getAttribute("categoria");
	%>
	
	<br />
	<form action="NovaCategoriaServlet2" method="post" >
		<input type="hidden" name="id" value="<%=categoria != null ? categoria.getId() : ""%>" />
			Nome:<input type="text" name="nome" value="<%=categoria != null ? categoria.getNome() : ""%>" /><br />
			
		<input type="submit" value="salvar"/>
	</form>
	


</body>
</html>