<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List, model.Grupos"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	List<Grupos> listaGrupos=(List<Grupos>)request.getAttribute("listaGrupos");
%>
		<form action="GruposControlServlet" method="post">
			<input type="submit" value="CarregarGrupos" name="CarregarGrupos">
		</form>
	
	<div id="Principal">
	 <p> Tabela </p>
		<% if( listaGrupos != null) { %>
		   <P> interno </P>
			<table border="2">
			<thead>
		
				<tr>
					<th>Grupo</th>
					<th>Time</th>
				
				</tr>
			</thead>
			<tbody>
			<%
				for (Grupos g: listaGrupos) {
			%>

			<tr>
				<td><%=g.getGrupo()%></td>
				<td><%=g.getNomeTime()%></td>
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