<%@page import="model.Museo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTA MUSEI</title>
</head>
<style>

table,th,td{
border:2px solid black
}


</style>
<body>

<% List<Museo> musei=(List <Museo>)  request.getAttribute("lista"); %>
<fieldset>
<legend>LISTA MUSEI</legend>
<table>

<tr> <th>Nome</th> <th>Citta</th> <th></th> </tr>
<% for(Museo m: musei) { %>

<tr>
 <td><%=m.getNome() %> </td> 
 <td><%=m.getCitta() %> </td>
  <td> <a href="edit?id=<%=m.getId() %>">MODIFICA</a>  </td>
  </tr>

<%} %>



</table>



</fieldset>


</body>
</html>