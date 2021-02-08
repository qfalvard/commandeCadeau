<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Merci!</title>
</head>
<body>
	<p>Merci ${sessionScope.utilisateur.prenom} pour votre commande de ${commande.article.designation}, quantite: ${commande.quantite} </p>
	<br>
	<p>${sessionScope.utilisateur.nbPoints}</p>
	<a href="articles" >Retourner aux articles</a>
</body>
</html>