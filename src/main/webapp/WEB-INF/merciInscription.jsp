<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Merci!</title>
</head>
<body>

	<jsp:include page="entete.jsp" />

	<h1>Inscription</h1>
	
	Merci ${utilisateur.prenom} pour votre inscription !
	<br>
	<a href="index">Retour à l'index</a>
</body>
</html>