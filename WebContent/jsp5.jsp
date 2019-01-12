<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> V) Conditions matérielles</h1>
<h2> Locaux</h2>
<form  method="post" action="Servlet5">
<label>++</label><input type="radio" name="locaux" value="++"> <label> + </label>  <input type="radio" name="locaux" value="+"> <label>-</label> 
<input type ="radio" name ="locaux" value="-"> <label>--</label> <input type ="radio" name="locaux" value="--">

<h2> Taille du groupe satisfaisant </h2>
<label>++</label><input type="radio" name="taille" value="++"> <label> + </label>  <input type="radio" name="taille" value="+"> <label>-</label> 
<input type ="radio" name ="taille" value="-"> <label>--</label> <input type ="radio" name="taille" value="--">
     
      
<h2> Matériel mis a disposition </h2>
<label>++</label><input type="radio" name="mat" value="++"> <label> + </label>  <input type="radio" name="mat" value="+"> <label>-</label> 
<input type ="radio" name ="mat" value="-"> <label>--</label> <input type ="radio" name="mat" value="--">
      

      <button type="submit">Envoyer</button> 
      </form>
</body>
</html>