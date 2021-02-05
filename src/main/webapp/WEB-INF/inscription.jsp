<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription</title>
</head>
<body>

	<jsp:include page="entete.jsp" />

	<h1>Inscription</h1>
	<form action="inscription" method="post">
		<input type="text" name="NOM" placeHolder="Nom" /> <br />
		 <input type="text" name="PRENOM" placeHolder="Prénom" /> <br />
		 <input type="text" name="EMAIL" placeHolder="Email" /> <br />
  		 <input type="password" name="MOT_DE_PASSE" placeHolder="Mot de passe" /> <br/>
			<select name="ID_VILLE">
			<!-- La JSP reçoit de la servlet une liste de villeet parcourt cette liste en utilisant
			la balise foreach de la bibliotheque de valise JSTL (Java Standrat Tag Library)
			item : ce que l'on veut parcourir
			var : variable de boucle -->
			<c:forEach items="${villes}" var="ville">
				<option value="${ville.id}">${ville.nom}</option>
			</c:forEach>
		</select> <br />
		<input type="submit" value="Inscription" />
	</form>
</body>
</html>