<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> II) Contenu du stage en entreprise (si vous avez suivi un stage en entreprise)</h1>
<h2> Application pratique en entreprise correspondant aux acquisitions en centre de formation</h2>
<form  method="post" action="Servlet2"> 
<label>++</label><input type="radio" name="application" value="++"> <label> + </label>  <input type="radio" name="application" value="+"> <label>-</label> 
<input type ="radio" name ="application" value="-"> <label>--</label> <input type ="radio" name="application" value="--">

<h2>Suivi du stage en entreprise</h2>
<label>++</label><input type="radio" name="suivi" value="++"> <label> + </label>  <input type="radio" name="suivi" value="+"> <label>-</label> 
<input type ="radio" name ="suivi" value="-"> <label>--</label> <input type ="radio" name="suivi" value="--">
      <button type="submit">Envoyer</button> 
      </form>
</body>
</html>