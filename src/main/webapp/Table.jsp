<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <%@ page import="java.util.*"%>
    <%@ page import="java.io.*"%>
    <%@ page import="cs485.preprocessing.*"%>
    <%@ page import="cs485.database.interactions.*"%>
<body>
<% 
String type = session.getAttribute("type").toString();

if (type.equals("A")){
	String Animalin= session.getAttribute("Animal").toString();
    DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));
    for (Map.Entry<String, String[]> entry : Data.searchForAnimal(Animalin).entrySet()) {
        %>
            out.println("<p>" + entry.getKey() + "</p>\n");
        <%
    }
}
else if (type.equals("B")){
	String Appointmentin= session.getAttribute("Appointment").toString();
    DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));

    for (Map.Entry<String, String[]> entry : Data.searchForAppointment(Appointmentin).entrySet()) {
        %>
            <p><%entry.getKey();%></p>
        <%
    }
}
else if (type.equals("C")){
	String Drugin= session.getAttribute("Drug").toString();
    DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));

    for (Map.Entry<String, String[]> entry : Data.searchForDrug(Drugin).entrySet()) {
        %>
            <p><%entry.getKey();%></p>
        <%
    }
}
else if (type.equals("D")){
	String Recordsin= session.getAttribute("Records").toString();
    DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));

    for (Map.Entry<String, String[]> entry : Data.searchForRecord(Recordsin).entrySet()) {
        %>
            <p><%entry.getKey();%></p>
        <%
    }
}
else if (type.equals("E")){
	String Vetin= session.getAttribute("Vet").toString();
    DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));

    for (Map.Entry<String, String[]> entry : Data.searchForVet(Vetin).entrySet()) {
        %>
            <p><%entry.getKey();%></p>
        <%
    }
}
else if (type.equals("F")){
	String Ingredientin= session.getAttribute("Ingredients").toString();
    DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));

    for (Map.Entry<String, String[]> entry : Data.searchForIngredient(Ingredientin).entrySet()) {
        %>
            <p><%entry.getKey();%></p>
        <%
    }
}

/* else if (Appointmentin!= null&&!Appointmentin.trim().equals("") && Appointmentin!= null&&!Appointmentin.trim().equals("")){
    DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));

    for (Map.Entry<String, String[]> entry : Data.searchForAppointment(Appointmentin).entrySet()) {
        System.out.println("Key: " + entry.getKey() + " Value: " + Arrays.toString(entry.getValue()));
    }
} */
%>
</body>
</html>