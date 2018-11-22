<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Cadastro de Usuário">

	<jsp:body>
		<section class="infoSection container">
			
			<h1>Cadastro de Permissões para ${usuario.nome}</h1>
			
			<form:form action="${s:mvcUrl('UC#gravarPermissoes').build() }" method="post" commandName="usuario">
				<input type="hidden" value="${usuario.email}" name="email" >				
				<div class="form-group">
					<label>Permissões</label>
					<form:checkboxes items="${roles}" path="roles" cssClass="form-control" />
				</div> 
				<button class="btn btn-primary">Atualizar</button>
			</form:form>
		</section>
	</jsp:body>

</tags:pageTemplate>