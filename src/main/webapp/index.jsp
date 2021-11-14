<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="Index.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>

<body>
<div class="header">
<h1 class ="title">FDA DATABASE</h1>
</div>

	<%@ page import="java.io.*"%>
	<%@ page import="cs485.preprocessing.*"%>
	<%@ page import="cs485.database.interactions.*"%>
	
<div id="div1">
	<div id="formC">
	<form action="index.jsp" method="get">
		<h1>LOGIN</h1>
		Username: <br>
		<input id="username" name="username" type="text" /><br> 
		Password: <br>
		<input id="password" name="password" type="text" /><br> 
		<br> 
			<input id ="login" type="submit" Value="LOGIN" />
	</form>
		
<!-- 		<br>
			<input id ="forgot" type="submit" Value="Forgot Password?" /> -->
	<%
String Password=request.getParameter("password");
String Username=request.getParameter("username");

if (Password!= null&&!Password.trim().equals("") && Username!= null&&!Username.trim().equals("")){
	DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));
	boolean flag=Data.checkCredentials(Username,Password);
	if(flag) 
		{%><script type="text/javascript">window.location.replace("Collection.jsp");</script><%}
	else 
		{%><script type="text/javascript">confirm("These credentials do not exist");</script><% }
}

%>
	</div>
	</div>

</body>
</html>