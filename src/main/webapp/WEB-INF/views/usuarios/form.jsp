<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Cadastro de Usuário">

	<jsp:body>
		<section class="infoSection container">
			
			<h1>Cadastro de Usuário</h1>
			<p> ${message} </p>
			
			<form:form action="${s:mvcUrl('UC#gravar').build() }" method="post"  commandName="usuario">
				<div class="form-group">
					<label>Nome</label> <form:errors path="nome" />
					<form:input path="nome" cssClass="form-control" />
				</div>
				<div class="form-group">
			        <label>E-mail</label> <form:errors path="email" />
					<form:input type="email" path="email" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label>Senha</label> <form:errors path="senha" />
					<form:password path="senha" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label>Senha repetida</label> <form:errors path="senhaRepetida" />
					<form:password path="senhaRepetida" cssClass="form-control" />
				</div>
				<button class="btn btn-primary">Cadastrar</button>
			</form:form>
		</section>
	</jsp:body>

</tags:pageTemplate>