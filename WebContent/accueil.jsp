<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page d'authentification</title>
</head>
<body>
<form  method="post" action="ServletAccueil"> <label>login</label> <input type="text" name="login">
    <label> MotDePasse </label>  <input type="password" name="mdp">
      <button type="submit">Envoyer</button> 
       <%
               if(request.getParameter("erreur")!= null && request.getParameter("erreur").equalsIgnoreCase("true")){%>

                 <p style='color:red'>Utilisateur ou mot de passe incorrect</p>
              <% }
               %>
               </form>
     
</body>
</html>