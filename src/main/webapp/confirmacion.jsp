<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	if ( request.getSession().getAttribute("usuario") == null ){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} 
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Contacto</title>
	    <script>
        function redireccionar() {
            window.location.href = "${pageContext.request.contextPath}/contacto.jsp";
        }
    </script>

	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>
    
<!-- <h1>Don't say BlowJobs MJ</h1>  --> 
	<form action="Contacto" method="POST" autocomplete="on">
		<fieldset>
		 <legend>
		 	Contacto
		 </legend>
		 <ul>
    <h1>¡Gracias por contactarnos!</h1>
    <p>Los siguientes datos fueron enviados:</p>
    <p>Nombre: <%= request.getParameter("nombres") %></p>
    <p>Correo electrónico: <%= request.getParameter("correo") %></p>
    <p>Consulta: <%= request.getParameter("consulta") %></p>
	     </ul>
		 <form action="${pageContext.request.contextPath}/contacto.jsp" method="get">
        <button type="button" onclick="redireccionar()">Volver</button>
    	</form>
        </fieldset>
    </form>
<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>
</body>
</html>