<%@page import="model.Museo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>MODIFICA MUSEO</title>
</head>
<body>
<%  Museo m = (Museo) request.getAttribute("museo"); %>

<h1>MODIFICA MUSEO <%=m.getNome() %></h1>

<form  method="post" action="aggiorna">
Nome Museo<input type="text" name="nome" value="<%=m.getNome() %>"> <br>
Citta' Museo<input type="text"  name="citta" value="<%=m.getCitta() %>" > <br>
<input type="hidden"  name="id" value="<%=m.getId() %>">
<input type="submit" value="MODIFICA">
</form>

</body>
</html>