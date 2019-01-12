<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> I) Contenu du stage de centre de formation</h1>
<h2> Durée du stage</h2>
<form  method="post" action="Servlet1"> 
<label>++</label><input type="radio" name="duree" value="++"> <label> + </label>  <input type="radio" name="duree" value="+"> <label>-</label> 
<input type ="radio" name ="duree" value="-"> <label>--</label> <input type ="radio" name="duree" value="--">

<h2>Programme du stage</h2>
<label>++</label><input type="radio" name="Programme" value="++"> <label> + </label>  <input type="radio" name="Programme" value="+"> <label>-</label> 
<input type ="radio" name ="Programme" value="-"> <label>--</label> <input type ="radio" name="Programme" value="--">

<h2>Apport de connaissances théoriques</h2>
<label>++</label><input type="radio" name="Apport" value="++"> <label> + </label>  <input type="radio" name="Apport" value="+"> <label>-</label> 
<input type ="radio" name ="Apport" value="-"> <label>--</label> <input type ="radio" name="Apport" value="--">

<h2>Apport de connaissances pratiques</h2>
<label>++</label><input type="radio" name="pratiques" value="++"> <label> + </label>  <input type="radio" name="pratiques" value="+"> <label>-</label> 
<input type ="radio" name ="pratiques" value="-"> <label>--</label> <input type ="radio" name="pratiques" value="--">  

<h2>Adéquation avec l'objectif initial de la formation</h2>
<label>++</label><input type="radio" name="Adéquation" value="++"> <label> + </label>  <input type="radio" name="Adéquation" value="+"> <label>-</label> 
<input type ="radio" name ="Adéquation" value="-"> <label>--</label> <input type ="radio" name="Adéquation" value="--">         

     
      
      
      
      <button type="submit">Envoyer</button> 
      </form>
</body>
</html>