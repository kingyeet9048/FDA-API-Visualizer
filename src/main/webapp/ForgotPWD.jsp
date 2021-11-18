<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="PWDcss.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>

<body>
<div class="header">
<h1 class ="title">CHANGE PASSWORD</h1>
</div>

	<%@ page import="java.io.*"%>
	<%@ page import="cs485.preprocessing.*"%>
	<%@ page import="cs485.database.interactions.*"%>
	
<div id="div1">
	<div id="formC">
	<form action="index.jsp" method="get">

		User ID:<br>
		<input id="username" name="username" type="text" />
		<br> 
		Old Password:<br>
		<input id="OldPWD" name="OldPassword" type="text" />
		<br> 
		New Password:<br>
		<input id="NewPWD" name="NewPassword" type="text" />
		<br> 
		<br>
		<input id ="reset" type="submit" Value="Reset Password"/>
		<br>

		<input id ="back" type="button" Value="Back" onclick="window.location.replace('index.jsp')"/>

	</form>
	<%
String username=request.getParameter("username");
String oldP=request.getParameter("OldPassword");
String newP=request.getParameter("NewPassword");

if (oldP!= null&&!oldP.trim().equals("") && newP!= null&&!newP.trim().equals("") && username!= null&&!username.trim().equals("")){
	DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));
	boolean flag=Data.changePassword(username, oldP, newP);
	if(flag) {
		Data.closeConnection();
		%><script type="text/javascript">window.location.replace("index.jsp");</script><%}
	else 
		{
		Data.closeConnection();
		%><script type="text/javascript">confirm("Try again");</script><% }
}

%>
	</div>
	</div>

</body>
</html>