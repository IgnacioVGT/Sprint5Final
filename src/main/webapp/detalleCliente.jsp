<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="modelo.Cliente" %>

<%
	if ( request.getSession().getAttribute("usuario") == null ){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} 
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cliente</title>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>

<!-- Formato de Ventana -->
<!-- Podría desplegar por GRID -->
<!-- Consutlar opciones a CJ -->
<% Cliente user = (Cliente) request.getAttribute("cliente"); %>
<form>
	<fieldset>
		<legend>Cliente</legend>
		<ul>
			<li>RUT:
				<input disabled placeholder="<%= user.getRut().split("-")[0] %>">
				-
				<input disabled placeholder="<%= user.getRut().split("-")[1] %>" id="dv">
			</li>
			<li>Nombres:
				<input disabled placeholder=" <%= user.getNombres() %> ">
			</li>
			<li>Fecha Nacimiento:
				<input disabled placeholder=" <%= user.getFechaNacimiento().toString() %> " >
			</li>
			<li>Celular: +(56)
				<input disabled placeholder=" <%= user.getTelefono() %> ">
			</li>
			<li>Sistema de Salud:
				<input disabled placeholder=" <%= user.getSistemaSalud() %> ">
			</li>
			<li>AFP:
				<input disabled placeholder=" <%= user.getAfp() %> ">
			</li>
			<li>Dirección:
				<input disabled placeholder=" <%= user.getDireccion() %> ">
			</li>
			<li>Comuna:
				<input disabled placeholder=" <%= user.getComuna() %> ">
			</li>
		</ul>
		<a href="UsuarioRead"><button type="button">Atras</button></a>
		<a href="UsuarioRead"><button type="button">Atras</button></a>
	</fieldset>
</form>


<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>
</body>
</html>