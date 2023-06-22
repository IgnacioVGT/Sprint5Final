<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="modelo.Profesional" %>

<%
	if ( request.getSession().getAttribute("usuario") == null ){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} 
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Profesional</title>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>

<!-- Formato de Ventana -->
<!-- Podría desplegar por GRID -->
<!-- Consutlar opciones a CJ -->

<% Profesional user = (Profesional) request.getAttribute("profesional"); %>

<form>
	<fieldset>
		<legend>Administrativo</legend>
		<ul>
			<li>RUT: <input disabled
				placeholder="<%= user.getRut().split("-")[0] %>"> - <input
				disabled placeholder="<%= user.getRut().split("-")[1] %>" id="dv">
			</li>
			<li>Nombres: <input disabled
				placeholder=" <%= user.getNombres() %> ">
			</li>
			<li>Fecha Nacimiento: <input disabled
				placeholder=" <%= user.getFechaNacimiento().toString() %> ">
			</li>
			<li>Titulo: <input disabled
				placeholder=" <%= user.getTitulo() %> ">
			</li>
			<li>Fecha Ingreso: <input disabled
				placeholder=" <%= user.getFechaIngreso() %> ">
			</li>
		</ul>
		<a href="UsuarioRead"><button
				type="button">Atras</button></a>
	</fieldset>
</form>


	<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>
</body>
</html>