<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account list</title>
</head>
<body>
<table border="1">
		<tr>
			<th>
			  <form action="AccountController">
			  		<input type="submit" name="btn_new"
			  		value="New "/>
			  </form>
			  <a href="AccountReport">Print report</a>
			</th>
			<td>Id account</td>
			<td>Monto</td>
			<td>Fecha</td>
			<td>Sucursal</td>
		</tr>
		 <c:forEach var="account" items="${accounts}">
		 	 <tr>
		 	 	<td>
		 	 		<form action="AccountController">
		 	 			<input type="hidden" name="id" value="${account.id }">
		 	 			<input type="submit" name="btn_edit" value="Edit"/>
		 	 			 <input type="submit" name="btn_delete" value="Delete"/>
		 	 		</form>
		 	 	</td>
		 	 	<td>${account.id }</td>
		 	 	<td>${account.name }</td>
		 	 	<td>${account.groupAccount }</td>
		 	 	<td>${account.turn }</td>
		 	 </tr>	
		 </c:forEach>
	</table>
</body>
</html>