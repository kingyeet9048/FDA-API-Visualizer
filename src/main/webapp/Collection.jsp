<!DOCTYPE html>

<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="stylesheet" href="collectcss.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collection</title>
  <script
   src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"
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

<h1 class="title">Visualize Data</h1>

</div>
<script type="text/javascript">function logout(){window.location.replace("index.jsp")}</script>

	<%@ page import="java.io.*"%>
	<%@ page import="cs485.preprocessing.*"%>
	<%@ page import="cs485.database.interactions.*"%>
		
	<div id="div1">
	
	<h2 class="d-flex justify-content-center mb-1">Please select an attribute to search by and enter an id</h2>

	<form action="Collection.jsp" method="get">
	<div id="grid">
		<select class="form-select mb-1" name="Search_Attributes" id="Attributes">
		  <option value="Animal">Animal</option>
		  <option value="Appointment">Appointment</option>
		  <option value="Ingredients">Ingredients</option>
		  <option value="Drug">Drug</option>
		  <option value="Records">Records</option>
		  <option value="Vet">Vet</option>
		</select>
		<input type="text" id="id" name="id" placeholder="XXX-XXX-XXX" required>
		<div class="submit">
			<input id ="submit" type="submit" Value="SUBMIT">
			</div>
	</div>
	</form>

</div>

 <%
 		String search_attribute=request.getParameter("Search_Attributes");
		String id=request.getParameter("id");
		//A
	if (search_attribute != null && !search_attribute.trim().equals("") && search_attribute.equals("Animal")) {
		session.setAttribute("Animal", id);
		session.setAttribute("name", session.getAttribute("name"));
		session.setAttribute("ID", session.getAttribute("ID"));
		session.setAttribute("type", "A");
		request.getRequestDispatcher("/Table.jsp").forward(request, response);
	}//B
	else if(search_attribute != null && !search_attribute.trim().equals("") && search_attribute.equals("Appointment")){
		session.setAttribute("Appointment", id);
		session.setAttribute("name", session.getAttribute("name"));
		session.setAttribute("ID", session.getAttribute("ID"));
		session.setAttribute("type", "B");
		request.getRequestDispatcher("/Table.jsp").forward(request, response);
	}//C
	else if(search_attribute != null && !search_attribute.trim().equals("") && search_attribute.equals("Drug")){
		session.setAttribute("Drug", id);
		session.setAttribute("name", session.getAttribute("name"));
		session.setAttribute("ID", session.getAttribute("ID"));
		session.setAttribute("type", "C");
		request.getRequestDispatcher("/Table.jsp").forward(request, response);
	}//D
else if(search_attribute != null && !search_attribute.trim().equals("") && search_attribute.equals("Ingredients")){
	session.setAttribute("Ingredients", id);
	session.setAttribute("name", session.getAttribute("name"));
	session.setAttribute("ID", session.getAttribute("ID"));
	session.setAttribute("type", "D");
	request.getRequestDispatcher("/Table.jsp").forward(request, response);
	}//E
else if(search_attribute != null && !search_attribute.trim().equals("") && search_attribute.equals("Records")){
	session.setAttribute("Records", id);
	session.setAttribute("name", session.getAttribute("name"));
	session.setAttribute("ID", session.getAttribute("ID"));
	session.setAttribute("type", "E");
	request.getRequestDispatcher("/Table.jsp").forward(request, response);
}//F
else if(search_attribute != null && !search_attribute.trim().equals("") && search_attribute.equals("Vet")){
	session.setAttribute("Vet", id);
	session.setAttribute("name", session.getAttribute("name"));
	session.setAttribute("ID", session.getAttribute("ID"));
	session.setAttribute("type", "F");
	request.getRequestDispatcher("/Table.jsp").forward(request, response);
}
	
	%> 
<script>
// https://stackoverflow.com/questions/38799096/clear-input-fields-on-page-refresh-microsoft-edge
window.onload = function() {
	  document.getElementById('Animal').value = '';
	  document.getElementById('Records').value = '';
	  document.getElementById('Vet').value = '';
	  document.getElementById('Ingredients').value = '';
	  document.getElementById('Appointment').value = '';
	  document.getElementById('Drug').value = '';
	  }
	  
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