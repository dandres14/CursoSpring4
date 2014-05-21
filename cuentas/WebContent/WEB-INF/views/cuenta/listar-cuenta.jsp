<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Cuentas</title>
<script src="resources/js/system.js"></script>
<script	src="resources/js/jquery.js"></script>
</head>
<body>
	<table style="height: 10px; width: 775px;" border="1">
		<tr>
			<th>Código</th>
			<th>Descripcion</th>
			<th>Valor</th>
			<th>Tipo</th>
			<th>¿Pago?</th>
			<th>Fecha de Pago</th>
			<th>Acciones</th>
		</tr>
		<c:forEach items="${cuentas}" var="cuenta">
			<tr>
				<td>${cuenta.id}</td>
				<td>${cuenta.descripcion}</td>
				<td>${cuenta.valor}</td>
				<td>${cuenta.tipo}</td>
				<td id="cuenta_${cuenta.id}">
					<c:if test="${cuenta.pago eq false}">
						No pago
					</c:if>
					<c:if test="${cuenta.pago eq true }">
						Pago!
					</c:if>
				</td>
				<td><fmt:formatDate value="${cuenta.fechaPago.time}" pattern="dd/MM/yyyy" /></td>
				<td>
					<a href="eliminarCuenta?id=${cuenta.id}">Eliminar</a>
					<a href="muestraCuenta?id=${cuenta.id}">Modificar</a>
					<a href="#" onclick="pagarAhora(${cuenta.id});">Pagar</a>
				</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>