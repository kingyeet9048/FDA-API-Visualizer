<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="PWDcss.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>

<body>
<div class="header">
<h1 class ="title">RESET PASSWORD</h1>
</div>

	<%@ page import="java.io.*"%>
	<%@ page import="cs485.preprocessing.*"%>
	<%@ page import="cs485.database.interactions.*"%>
	
<div id="div1">
	<div id="formC">
	<form action="index.jsp" method="get">
		User ID:
		<input id="username" name="username" type="text" />
		<br> 
		<br>
		<input id ="reset" type="submit" Value="Reset Password"/>
	</form>
	<br>
		<input id ="back" type="submit" Value="Back"/>
	</div>
	</div>

</body>
</html>