
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="stylesheet" href="tablecss.css">
<script
src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js">
</script>
<meta charset="UTF-8">
<title>Data Table</title>
</head>
    <%@ page import="java.util.*"%>
    <%@ page import="java.io.*"%>
    <%@ page import="cs485.preprocessing.*"%>
    <%@ page import="cs485.database.interactions.*"%>
    
<div class="header">

<div class="IDUSER">
<p>Username: <% Object Password=session.getAttribute("name"); 
		out.println(Password); %> </p>

<p>Vet ID: <% Object ID=session.getAttribute("ID"); 
		out.println(ID); %></p> 
<a id="logout" onclick="logout()">LOGOUT</a> <%out.print("|"); %>
<a id="logout" onclick="back()">BACK</a>
</div>
<script type="text/javascript">function logout(){window.location.replace("index.jsp")}</script>
<script type="text/javascript">

function back(){window.location.replace("Collection.jsp")}

</script>
<h1 class="title">DATA TABLE</h1>

</div>

<body>

<% 
String type = session.getAttribute("type").toString();
Map<String, String[]> entry = new HashMap<String, String[]>();
DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));
if (type.equals("A")){
	String Animalin= session.getAttribute("Animal").toString();
    entry = Data.searchForAnimal(Animalin);

}
else if (type.equals("B")){
	String Appointmentin= session.getAttribute("Appointment").toString();
	entry = Data.searchForAppointment(Appointmentin);
}
else if (type.equals("C")){
	String Drugin= session.getAttribute("Drug").toString();
	entry = Data.searchForDrug(Drugin);
}
else if (type.equals("D")){
	String Ingredientin= session.getAttribute("Ingredients").toString();
	entry = Data.searchForIngredient(Ingredientin);
}
else if (type.equals("E")){
	String Recordsin= session.getAttribute("Records").toString();
	entry = Data.searchForRecord(Recordsin);
}
else if (type.equals("F")){
	String Vetin= session.getAttribute("Vet").toString();
	entry = Data.searchForVet(Vetin);
}
out.println("<TABLE id='shadow' class='w-auto table table-striped' BORDER=1 ALIGN=CENTER>");
out.println("<thead class='thead-dark'>");
out.println("<TR>");
Object[] keys;
if (entry == null) {
	out.println("No data found for the given id");
}
else {
	keys = entry.keySet().toArray();
	String headers = "";
	for(String key: entry.keySet()){
		out.println("<TH scope='col'>"+ key + "</TH>");
		headers += key + "#";
	}
	out.println("</TR>");
	out.println("</thead>");
	out.println("<tbody>");
	String lengths = "";
	for(int i = 0; i < entry.keySet().size(); i++) {
		lengths += entry.get((String)keys[0]).length + "#";
	}
	for(int i = 0; i < entry.get((String)keys[0]).length; i++){
		 out.println("<TR>" );
		 for (int j = 0; j < entry.size(); j++) {
			 out.println("<TD>" + entry.get((String)keys[j])[i] + "</TD>");
		 }
		 out.println("</TR>" );
	}
	out.println("</tbody>");
	out.println("</TABLE>");
	out.println("<script type='text/javascript'>localStorage.setItem('headers','" +headers.substring(0, headers.length() - 1)+"')</script>");
	out.println("<script type='text/javascript'>localStorage.setItem('lengths','" +lengths.substring(0, lengths.length() - 1)+"')</script>");
	out.println("<div class='d-flex justify-content-center'><canvas id='myChart' style='width:100%;max-width:700px'></canvas></div>");
	out.println("<script type='text/javascript'>function random_rgba(numbers) {var colors = [];for (var i = 0; i < numbers; i++) {var o = Math.round, r = Math.random, s = 255;colors.push('rgba(' + o(r()*s) + ',' + o(r()*s) + ',' + o(r()*s) + ',' + r().toFixed(1) + ')');	}return colors;}var xValues = localStorage.getItem('headers').split('#');var yValues = localStorage.getItem('lengths').split('#').map(function(item) {return parseInt(item, 10);});var colors = random_rgba(yValues.length);new Chart('myChart', {type: 'pie',data: {labels: xValues,datasets: [{backgroundColor: colors,data: yValues}]},options: {title: {display: true,text: 'FDA Chart'}}});</script>");
}


%>

</body>
</html>