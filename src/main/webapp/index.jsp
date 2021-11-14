<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<form action="index.jsp" method="get">
		<h1>LOGIN</h1>
		Username: <br>
		<input id="username" name="username" type="text" /><br> 
		Password: <br>
		<input id="password" name="password" type="text" /><br> 
		<br> 
			<input id ="login" type="submit" Value="LOGIN" ></input>
<br>
			<input id ="forgot" type="submit" Value="Forgot Password?"></input>
	</form>
	</div>
	<%-- <%
	DataCollector dataCollector = new DataCollector(new String[] {
			"https://download.open.fda.gov/animalandveterinary/event/2021q1/animalandveterinary-event-0001-of-0001.json.zip",
			"https://download.open.fda.gov/animalandveterinary/event/2021q2/animalandveterinary-event-0001-of-0001.json.zip" });
	try {
		dataCollector.fetchSaveData();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%> --%>

</body>
</html>