<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${sessionScope.utilisateur eq null }">
		<a href="inscription">Inscription</a>
		<br>
		<a href="connexion">Connexion</a>
		<br>
		<a href="articles">Articles</a>
	</c:when>
	<c:when test="${sessionScope.utilisateur ne null }">
		<a href="deconnexion">Deconnexion</a>
		<br>
		Bonjour, ${sessionScope.utilisateur.prenom}
			${sessionScope.utilisateur.nom}!
		<br>
		<a href="commandes">afficher mes commandes</a>
		<br>
	</c:when>
</c:choose>