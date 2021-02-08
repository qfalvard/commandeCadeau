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
	
	<c:if test="${utilisateurNonConnecte ne null}">
		<span style="color : red;">${utilisateurNonConnecte}</span>
		<br>
	</c:if>
	
	<c:if test="${nofication ne null}">
		<span style="color : red;">${notification}</span>
		<br>
	</c:if>
	
	<h1>Liste des articles</h1>

	<c:forEach items="${articles}" var="article">
		<a href="article?ID=${article.id}">${article.designation}</a>(${article.categorie.nom}) (nbPts: ${article.nbPoints}) (stock:
			${article.stock})
<!-- 			// On rajoute de la couleur -->
<c:choose>
    <c:when test="${article.stock > 5}">
        <c:set var="color" value="#1DF942"></c:set>
    </c:when>
    <c:when test="${article.stock == 0}">
        <c:set var="color" value="#F91D1D"></c:set>
    </c:when>
    <c:otherwise>
        <c:set var="color" value="#F78315"></c:set>
    </c:otherwise>
</c:choose>

<span style="color:${color};"><c:out value="stock: ${article.stock}" /></span>
		<br>

	</c:forEach>
	<br>
	nombre d'article ${articles.size()}
	<br>
</body>
</html>