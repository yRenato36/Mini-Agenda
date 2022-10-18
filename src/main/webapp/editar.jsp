<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<!-- colocando um icone na aba do browser -->
<link rel="icon" href="imagens/favicon.png">

<!--linkando o arquivo css -->
<link rel="stylesheet" href="style.css">
</head>

<body>
	<h1>Editar contato</h1>
	<form name="frmContato" action="">
		<table>
			<tr><!-- no CSS classes são para utilizar em mais de um elemento, já o id é utilizado em elementos expecíficos, como o exemplo abaixo -->
				<td><input type="text" name="idcon" id="caixa3" readonly value="<%out.print(request.getAttribute("idcon"));%>"></td> <!-- value irá printar o que ele buscou da classe Controller -->
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="Caixa2" value="<%out.print(request.getAttribute("fone"));%>>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="Caixa1" value="<%out.print(request.getAttribute("email"));%>"></td>
				<!-- adiciona um textbox -->
			</tr>
		</table>
		<input type="button" class="Botao1" value="Salvar" onclick="validar()">
		<!-- validar()função do Javascript que valida os campos deste formulário -->
		<!-- cria um botão dentro do fomulário -->
	</form>
	<script src="scripts/validador.js"></script>
	<!-- referencia o documento Javascript -->
</body>