<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signature electronique</title>
</head>
<body>
<form method="post" action="ServletMail">
 <label> Code </label> <input type="number" name="code">
    
    <button type="submit">Envoyer</button>
<button type="submit">Envoyer</button> 
 <%
               if(request.getParameter("erreur")!= null && request.getParameter("erreur").equalsIgnoreCase("true")){%>

                 <p style='color:red'>Code erroné !</p>
              <% }
               %>
</form>

</body>
</html>