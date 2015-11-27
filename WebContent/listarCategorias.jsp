<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.unipe.entities.Categoria, java.util.List" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Categorias</title>
</head>
<body>
	<% 
	String filtro = request.getParameter("filtro");
	%>
    <a href="NovaCategoriaServlet2" >Novo</a>
		<form action="ListarCategoriaServlet" method="get">
			Pesquisar por nome:<input type="text" name="filtro" value="<%=filtro != null ? filtro : "" %>"/>
		<input type="submit" value="pesquisar" />
		</form>
	<table>
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td>Ações</td>
		</tr>

		<% 
		
		List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
			for (Categoria categoria : categorias) {%>
		
		<tr>
			<td><%=categoria.getId()%></td>
			<td><%=categoria.getNome()%></td>
			<td>
				<a href="RemoverCategoria?id=<%=categoria.getId()%>">Remover</a>
				<a href="NovaCategoriaServlet2?id=<%=categoria.getId()%>">Editar</a>
			</td>
		</tr>
		<%}%>

	</table>


</body>
</html>