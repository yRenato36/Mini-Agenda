<!-- documentos .jsp são HTML que conseguem executar comandos em JAVA -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
		//Recebe o objeto ArrayList com nome de lista
		ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
		
	
	
		/* teste para ver se o ArrayList está trazendo todos os dados do BD, depois printando no agenda.jsp
		for (int i = 0; i < lista.size(); i++) {
			out.println(lista.get(i).getIdcon());
			out.println(lista.get(i).getNome());
			out.println(lista.get(i).getFone());
			out.println(lista.get(i).getEmail());
		}*/
	%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="ican" href="imagens/favican.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="novo.html" class="Botao1">Novo contato</a>
	<!-- criando uma lista neste HTML -->
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>E-mail</th>

			</tr>
		</thead>
		<tbody>
			<!--scriplet-->
			<%for (int i = 0; i < lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getIdcon() %></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getFone() %></td>
					<td><%=lista.get(i).getEmail() %></td>
				</tr>
				
			<%} %>
		</tbody>
	</table>
</body>
</html>