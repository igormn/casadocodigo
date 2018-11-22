<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Pedidos">

	<jsp:body>
		<section class="infoSection container">
			
			<h2>Lista de Pedidos Atuais</h2>
			
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Valor</th>
						<th>Data Pedido</th>
						<th>Títulos</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${pedidos}" var="pedido">
						<tr>
							<td>${pedido.id}</td>
							<td><fmt:formatNumber value="${pedido.valor}" type="number" maxFractionDigits="2"/></td>
							<td><fmt:formatDate value="${pedido.data.time}" pattern="dd/MM/yyyy"/></td>
							<td>${pedido.titulosDosProdutos}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</jsp:body>

</tags:pageTemplate>