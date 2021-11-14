<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="collection.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collection</title>
</head>

<body>
<div class="header">
<h1 class ="title">DATA COLLECTION</h1>
</div>

	<%@ page import="java.io.*"%>
	<%@ page import="cs485.preprocessing.*"%>
	<%@ page import="cs485.database.interactions.*"%>
	

	<div id="div1">
	<form action="index.jsp" method="get">
	<div id="grid">
	<div id="input1">
		Organization: <br>
		<input id="Organization" name="Organization" type="text" />
		</div>
		<div id="input2">Animal: <br>
		<input id="Animal" name="Animal" type="text" />
		</div>
		<div id="input3"></div>
		<div id="input4"></div>
		<div id="input5"></div>
		<div id="input6"></div>
		<div id="input7"></div>
		<div id="input8"></div>
		<br> 
			<input id ="login" type="submit" Value="LOGIN" ></input>
</div>
	</form>
	
</div>

</body>
</html>