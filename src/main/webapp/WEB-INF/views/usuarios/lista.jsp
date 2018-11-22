<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Cadastro de Usuário">

	<jsp:body>
		<section class="infoSection container">
			
			<br/><a href="${s:mvcUrl('UC#form').build() }"><fmt:message key="link.cadastro.usuario"/></a>
			
			<h1>Lista de Usuários</h1>
			<p> ${message} </p>
		
			<table class="table table-bordered table-striped table-hover">
				<tr>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Roles</th>
					<th></th>
				</tr>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td>${usuario.nome}</td>
						<td>${usuario.email}</td>
						<td>
							<c:choose>
								<c:when test="${not empty usuario.roles}">
									${usuario.roles}
								</c:when>
								<c:otherwise>[USUÁRIO SEM ROLES ASSOCIADAS]</c:otherwise>
							</c:choose>
						</td>
						<td><a href="${s:mvcUrl('UC#editarPermissoes').arg(0, usuario.email).build()}" class="botaoeditar">+</a> </td>
					</tr>
				</c:forEach>
			</table>
		</section>
	</jsp:body>

</tags:pageTemplate>