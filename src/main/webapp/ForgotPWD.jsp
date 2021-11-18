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
		<input id ="reset" type="button" Value="Reset Password" onclick="" />
		<br>

		<input id ="back" type="button" Value="Back" onclick="window.location.replace('index.jsp')"/>

	</form>
<script>

</script>
	</div>
	</div>

</body>
</html>