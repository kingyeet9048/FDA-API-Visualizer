<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="PWDcss.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Activate Vet</title>
</head>

<body>
<div class="header">
<h1 class ="title">Activate Vet</h1>
</div>

	<%@ page import="java.io.*"%>
	<%@ page import="cs485.preprocessing.*"%>
	<%@ page import="cs485.database.interactions.*"%>
	
<div id="div1">
	<div id="formC">
	<form action="ActivateUser.jsp" method="get">

		Vet ID:<br>
		<input id="vetid" name="vetid" type="text" />
		<br> 

		<input id ="back" type="submit" Value="Back"/>

	</form>
	<%
String username=request.getParameter("vetid");

if (username!= null&&!username.trim().equals("")){
	DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));
	boolean flag=Data.activateAccount(username);
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