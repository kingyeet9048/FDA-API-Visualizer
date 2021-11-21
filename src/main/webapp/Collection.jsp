<!DOCTYPE html>

<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<link rel="stylesheet" href="collectcss.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collection</title>
  <script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
></script>
</head>
<body>

<div class="header">

<div class="IDUSER">
<p>Username: <% Object Password=session.getAttribute("name"); 
		out.println(Password); %> </p>

<p>Vet ID: <% Object ID=session.getAttribute("ID"); 
		out.println(ID); %></p> 
<a id="logout" onclick="logout()">LOGOUT</a>
</div>

<h1 class="title">DATA COLLECTION</h1>

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
		<input id="Animal" name="Animal" type="text" onkeyup="toggleInputs(this)"/>
		</div>
		
		<div class="input">
		Appointment: <br>
		<input id="Appointment" name="Appointment" type="text" onkeyup="toggleInputs(this)"/>
		</div>
		
		
		<div class="input">
		Drug: <br>
		<input id="Drug" name="Drug" type="text" onkeyup="toggleInputs(this)"/>
		</div>
		
		<div class="input">
		Ingredients: <br>
		<input id="Ingredients" name="Ingredients" type="text" onkeyup="toggleInputs(this)"/>
		</div>

		
		<div class="input">
		Records: <br>
		<input id="Records" name="Records" type="text" onkeyup="toggleInputs(this)"/>
		</div>
		
		<div class="input">
		Vet: <br>
		<input id="Vet" name="Vet" type="text" onkeyup="toggleInputs(this)"/>
		</div>
		<div class="input">
		<p></p>
		</div>
		<div class="submit">
			<input id ="submit" type="submit" Value="SUBMIT">
			</div>
	</div>
	</form>
	
</div>

 <%
 		String Animalin=request.getParameter("Animal");
		String Appointmentin=request.getParameter("Appointment");
		String Drugin=request.getParameter("Drug");
		String Ingredientsin=request.getParameter("Ingredients");
		String Recordsin=request.getParameter("Records");
		String Vetin=request.getParameter("Vet");
	if (Animalin != null && !Animalin.trim().equals("")) {
		session.setAttribute("Animal", Animalin);
		session.setAttribute("name", session.getAttribute("name"));
		session.setAttribute("ID", session.getAttribute("ID"));
		session.setAttribute("type", "A");
		request.getRequestDispatcher("/Table.jsp").forward(request, response);
	}
	else if(Appointmentin != null && !Appointmentin.trim().equals("")){
		session.setAttribute("Appointment", Appointmentin);
		session.setAttribute("name", session.getAttribute("name"));
		session.setAttribute("ID", session.getAttribute("ID"));
		session.setAttribute("type", "B");
		request.getRequestDispatcher("/Table.jsp").forward(request, response);
	}
	else if(Drugin != null && !Drugin.trim().equals("")){
		session.setAttribute("Drug", Drugin);
		session.setAttribute("name", session.getAttribute("name"));
		session.setAttribute("ID", session.getAttribute("ID"));
		session.setAttribute("type", "C");
		request.getRequestDispatcher("/Table.jsp").forward(request, response);
	}
else if(Ingredientsin != null && !Ingredientsin.trim().equals("")){
	session.setAttribute("Records", Recordsin);
	session.setAttribute("name", session.getAttribute("name"));
	session.setAttribute("ID", session.getAttribute("ID"));
	session.setAttribute("type", "D");
	request.getRequestDispatcher("/Table.jsp").forward(request, response);
	}
else if(Recordsin != null && !Recordsin.trim().equals("")){
	session.setAttribute("Vet", Vetin);
	session.setAttribute("name", session.getAttribute("name"));
	session.setAttribute("ID", session.getAttribute("ID"));
	session.setAttribute("type", "E");
	request.getRequestDispatcher("/Table.jsp").forward(request, response);
}
else if(Vetin != null && !Vetin.trim().equals("")){
	session.setAttribute("Ingredients", Ingredientsin);
	session.setAttribute("name", session.getAttribute("name"));
	session.setAttribute("ID", session.getAttribute("ID"));
	session.setAttribute("type", "F");
	request.getRequestDispatcher("/Table.jsp").forward(request, response);
}
	
/* 	if (Animalin!= null&&!Animalin.trim().equals("") && Animalin!= null&&!Animalin.trim().equals("")){
		DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));

		for (Map.Entry<String, String[]> entry : Data.searchForAnimal(Animalin).entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + Arrays.toString(entry.getValue()));
			session.setAttribute("animal", Animalin);
		}
	}
	else if (Appointmentin!= null&&!Appointmentin.trim().equals("") && Appointmentin!= null&&!Appointmentin.trim().equals("")){
		DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));

		for (Map.Entry<String, String[]> entry : Data.searchForAppointment(Appointmentin).entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + Arrays.toString(entry.getValue()));
		}
	} */
	%> 
<script>

function toggleInputs(e){
    if(e.value!==''){
        $('input[type="text"]:not(#'+e.id+')').prop('disabled', true); //disable
    }
    else {
        $('input[type="text"]').prop('disabled', false) //enable
    }

 }
</script>
</body>
</html>