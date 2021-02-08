<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="entete.jsp" />
	<h1>Liste des articles</h1>

	<c:forEach items="${articles}" var="article">
		<a href="article?ID=${article.id}">${article.designation}</a>(${article.categorie.nom}) (nbPts: ${article.nbPoints}) (stock:
			${article.stock})
		<br>
	</c:forEach>
	<br>
	nombre d'article ${articles.size()}
	<br>
</body>
</html>