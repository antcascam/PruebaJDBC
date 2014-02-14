<%--
	Document:	index.jsp
	Created on:	07/10/2012 at 20:04:05
	Author:		José Luis
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>INDEX (Probando con Servlets y JDBC)</title>
	</head>
	<body>
		<form name="FORM1" method="GET" action="listaservlet">
	        <fieldset>
	            <legend>Entrada GET</legend>  
	              <label id="label_NameGET" for="nameget">Nombre:</label>
	              <input id="nameget" name="nameget" type="text"/>
	              <label id="label_ApelGET" for="apelget">Apellidos:</label>
	              <input id="apelget" name="apelget" type="text"/>
	              <input id="botonget" type="submit" value="Enviar">
			</fieldset>
      	</form>
      	<form name="FORM2" method="POST" action="listaservlet">
	        <fieldset>
	            <legend>Entrada POST</legend>  
	              <label id="label_POST" for="namepost">Nombre:</label>
	              <input id="namepost" name="namepost" type="text"/>
	              <label id="label_ApelPOST" for="apelpost">Apellidos:</label>
	              <input id="apelpost" name="apelpost" type="text"/>
	              <input id="botonpost" type="submit" value="Enviar">
			</fieldset>
      	</form>
	</body>
</html>