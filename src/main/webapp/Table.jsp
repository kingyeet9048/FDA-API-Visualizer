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
String Animalin= session.getAttribute("Animal").toString();

if (Animalin!= null&&!Animalin.trim().equals("") && Animalin!= null&&!Animalin.trim().equals("")){
	DatabaseConnection Data=new DatabaseConnection(request.getRealPath(".env"));

	for (Map.Entry<String, String[]> entry : Data.searchForAnimal(Animalin).entrySet()) {
		System.out.println("Key: " + entry.getKey() + " Value: " + Arrays.toString(entry.getValue()));
		session.setAttribute("animal", Animalin);
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