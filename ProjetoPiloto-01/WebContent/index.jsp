<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List, model.Times"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Times</title>
</head>
<body>

<%
List<Times> listatimes=(List<Times>)request.getAttribute("lista");


%>
	<div id="buscar">
		<form action="TimesControlServlet" method="post">
			<input type="submit" value="CarregarTimes" name="CarregarTimes">
		</form>
	
	</div>
	<div id="Principal">
	 <p> Tabela </p>
		<% if( listatimes != null) { %>
		   <P> interno </P>
			<table border="2">
			<thead>
		
				<tr>
					<th>codigo</th>
					<th>Time</th>
					<th>Cidade</th>
					<th>Estadio</th>
				</tr>
			</thead>
			<tbody>
			<%
				for (Times t: listatimes) {
			%>

			<tr>
				<td><%=t.getCodigoTime()%></td>
				<td><%=t.getNomeTime()%></td>
				<td><%=t.getCidade()%></td>
				<td><%=t.getEstadio()%></td>
				
			</tr>
			<%
				
				}
			%>
		</tbody>
			</table>
		<% } %>
	</div>
</body>
</html>