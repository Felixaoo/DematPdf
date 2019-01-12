<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="ServletCommentaire">
<h1>Si vous souhaitez commenter la formation en général :</h1>
<label for="story">Commentaire:</label>

<textarea id="commentaire" name="commentaire"
          rows="5" cols="33">
</textarea>
<button type="submit">Envoyer</button> 
</form>

</body>
</html>