<%@ page import="afpa.fr.service.ServicesAuthentification" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<FORM action="ServletFormulaire"> 
<SELECT name="nom" size="1">
<% ServicesAuthentification ser = new ServicesAuthentification();
String listId= ser.recupId();
String []tab=listId.split(";");
for(int i=0; i<tab.length; i++){
	%><OPTION> <%= tab[i] %>
<%} %>

</SELECT>
  <button type="submit">Envoyer</button>
  
</FORM>
 
</body>
</html>