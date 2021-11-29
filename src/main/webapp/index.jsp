<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="Index.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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
			<input id ="login" type="submit" Value="LOGIN"/>
			<br>
			<input id ="change" type="button" Value="Change Password" onclick="window.location.replace('ForgotPWD.jsp')"/>
			<input id ="change" type="button" Value="Activate Vet" onclick="window.location.replace('ActivateUser.jsp')"/>
			

	</form>
		
<!-- 		<br>
			<input id ="forgot" type="submit" Value="Forgot Password?" /> -->
	<%
String Password=request.getParameter("password");
String Username=request.getParameter("username");
session.setAttribute("name", Username);
if (Password!= null&&!Password.trim().equals("") && Username!= null&&!Username.trim().equals("")){
	DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));
	boolean flag=Data.checkCredentials(Username,Password);
	if(flag) {
		session.setAttribute("ID", Data.getID());
		Data.closeConnection();
		%><script type="text/javascript">window.location.replace("Collection.jsp");</script><%}
	else 
		{
		Data.closeConnection();
		%><script type="text/javascript">confirm("These credentials do not exist");</script><% }
}

%>
	</div>
	</div>

</body>
</html>