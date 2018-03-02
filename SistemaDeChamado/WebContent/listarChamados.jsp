<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Listar Chamados</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>
<body>
	<!-- Modal -->
			<c:if test="${not empty mensagem}">
						<div class="col-md-12">
							<div class="alert alert-danger alert-dismissable" style="margin-top: 10px;">							
								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								<strong>${mensagem}</strong>
							</div>
						</div>
			</c:if>
	<!-- /.Modal -->
	
	<div id="main" class="container">
		<div class="row" align=center style="margin-bottom: 30px;">
			<div class="col-md-12">
				<h2>Listar Chamados</h2>
			</div>
		</div>
		<div class='tudo'>
			<c:if test="${not empty mensagem}">
						<div class="col-md-12">
							<div class="alert alert-danger alert-dismissable" style="margin-top: 10px;">							
								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								<strong>${mensagem}</strong>
							</div>
						</div>
			</c:if>
			<!-- Container Principal -->
			<form action="listar_Chamados.do" method="post" style ="margin-top: 30px">
				<div class="row col-md-12">
					<!-- Chamados -->
					<div class="col-md-12">
					<label for="areaAtuacao">Escolha a Fila:</label>
					<div class="input-group col-md-12">
						<select class="form-control" name="id_Chamado" id="id_Chamado">
							<!--  <option value=off selected disabled>Selecione</option> -->
							<option value="novosProjetos">Novos Projetos</option>
							<option value="manutencaoSistemDdeVendas">Manutenção Sistema de Vendas</option>
							<option value="manutencaoSistemaERP">Manutenção Sistema ERP</option>
							<option value="servidores">Servidores</option>
							<option value="redes">Redes</option>
							<option value="telefonia">Telefonia</option>
							<option value="desktops">Desktops</option>
							<c:forEach var="lista" items="${lista}">
								<option value="${lista.id_Fila}">${lista.id_Chamado}</option>	
							</c:forEach>
						</select> 
					</div>
					</div>	
				</div>
			<div class="row" align="center">
				<div class="table-responsive col-md-12">
					<button type="submit" class="btn btn-primary" id="buscar" name="acao" value="Buscar">Listar Chamados</button>	
			    </div>
			</div>
		</form>
	</div>

</body>
</html>