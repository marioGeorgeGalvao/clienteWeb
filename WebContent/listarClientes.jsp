<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="edu.unipe.entities.Cliente, java.util.List" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Clientes</title>
</head>
<body>
	<% 
	String filtro = request.getParameter("filtro");
	%>
    <a href="formularioCadastro" >Novo</a>
		<form action="listarClientes" method="get">
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
		
		List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
		for (Cliente cliente : clientes) {%>
		
		<tr>
			<td><%=cliente.getId()%></td>
			<td><%=cliente.getNome()%></td>
			<td>
				<a href="removerCliente?id=<%=cliente.getId()%>">Remover</a>
				<a href="formularioCadastro?id=<%=cliente.getId()%>">Editar</a>
			</td>
		</tr>
		<%}%>

	</table>


</body>
</html>