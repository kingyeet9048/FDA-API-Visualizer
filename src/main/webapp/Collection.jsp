<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<link rel="stylesheet" href="collectcss.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collection</title>
</head>
<body>
<div class="wrapper">
<div class="header">

<div id="IDUSER">
<p> <% Object Password=session.getAttribute("name"); 
		out.println(Password); %> </p>

<p><% Object ID=session.getAttribute("ID"); 
		out.println(ID); %></p> 
<a id="logout" onclick="logout()">LOGOUT</a>
</div>

<h1 class ="title">DATA COLLECTION</h1>

</div>
<script type="text/javascript">function logout(){window.location.replace("index.jsp")}</script>

	<%@ page import="java.io.*"%>
	<%@ page import="cs485.preprocessing.*"%>
	<%@ page import="cs485.database.interactions.*"%>
	

	<div id="div1">
	<form action="Collection.jsp" method="get">
	<div id="grid">
	
		<div class="input">
		Animal: <br>
		<input id="Organization" name="Organization" type="text" />
		</div>
		
		<div class="input">
		Animal_Outcome: <br>
		<input id="Animal_Outcome" name="Animal_Outcome" type="text" />
		</div>
		
		<div class="input">
		Animals_in_Records: <br>
		<input id="Animals_in_Records" name="Animals_in_Records" type="text" />
		</div>
		
		<div class="input">
		Appointment: <br>
		<input id="Appointment" name="Appointment" type="text" />
		</div>
		
		<div class="input">
		Appointment_Animals: <br>
		<input id="Appointment_Animals" name="Appointment_Animals" type="text" />
		</div>
		
		<div class="input">
		Appointment_Outcome: <br>
		<input id="Appointment_Outcome" name="Appointment_Outcome" type="text" />
		</div>
		
		<div class="input">
		Drug: <br>
		<input id="Drug" name="Drug" type="text" />
		</div>
		
		<div class="input">
		Drug_ingredient: <br>
		<input id="Drug_ingredient" name="Drug_ingredient" type="text" />
		</div>
		
		<div class="input">
		Drugs_in_Records: <br>
		<input id="Drugs_in_Records" name="Drugs_in_Records" type="text" />
		</div>
		
		<div class="input">
		Exposure: <br>
		<input id="Exposure" name="Exposure" type="text" />
		</div>
		
		<div class="input">
		Ingredients: <br>
		<input id="Ingredients" name="Ingredients" type="text" />
		</div>
		
		<div class="input">
		Login: <br>
		<input id="Login" name="Login" type="text" />
		</div>
		
		<div class="input">
		Organizations: <br>
		<input id="Organizations" name="Organizations" type="text" />
		</div>
		
		<div class="input">
		OR_Vet_Login: <br>
		<input id="OR_Vet_Login" name="OR_Vet_Login" type="text" />
		</div>
		
		<div class="input">
		Owners: <br>
		<input id="Owners" name="Owners" type="text" />
		</div>
		
		<div class="input">
		Records: <br>
		<input id="Records" name="Records" type="text" />
		</div>
		
		<div class="input">
		Vet: <br>
		<input id="Vet" name="Vet" type="text" />
		</div>
		<div class="submit">
			<input id ="submit" type="submit" Value="SUBMIT" >
			</div>
	</div>
	</form>
	
</div>
</div>
</body>
</html>