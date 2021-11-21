<%-- <%@page import="com.google.gson.internal.LinkedHashTreeMap.EntrySet"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="tablecss.css">
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
<a id="logout" onclick="logout()">LOGOUT</a>
</div>
<script type="text/javascript">function logout(){window.location.replace("index.jsp")}</script>
<h1 class="title">DATA TABLE</h1>

</div>

<body>
<div id="div1">
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
out.println("<TABLE BORDER=1 ALIGN=CENTER>");
out.println("<TR>");
Object[] keys = entry.keySet().toArray();
for(String key: entry.keySet()){
	out.println("<TH>"+ key + "</TH>");
}
out.println("</TR>");
int currentRow = 0;
for(int i = 0; i < entry.get((String)keys[0]).length; i++){
	 out.println("<TR>" );
	 for (int j = 0; j < entry.size(); j++) {
		 out.println("<TD>" + entry.get((String)keys[j])[i] + "</TD>");
	 }
	 out.println("</TR>" );
}
out.println("</TABLE>");
/* out.println("<p>" + "Key: " + entry1.getKey() + " -> Value: " + Arrays.toString(entry1.getValue()) + "</p>\n");
System.out.println("Key: " + entry1.getKey() + " -> Value: " + Arrays.toString(entry1.getValue())); */
// out.println("<TR BGCOLOR=\"#FFAD00\">\n" + "<TH colspan = '2' >Order Information");
// <TD> <TR> <TH> <TD> out.println("<TD>" + paramName + "<TD>");
//for(int i = 0; i < )


%>
</div>
</body>

</html>