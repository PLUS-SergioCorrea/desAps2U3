<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Form</title>
</head>
<body>
	<form action="AccountController">
		<label>Monto:</label><br />
		<input type="text" name="name" value="${account.name }" /><br />
		<label>Fecha:</label><br />
		<input type="text" name="group_account" value="${account.groupAccount }" /><br />
		<label>Sucursal:</label><br />
		<input type="text" name="turn" value="${account.turn }" /><br />
		<input type="submit" name="btn_save" value="Save" />	
	</form>
</body>
</html>