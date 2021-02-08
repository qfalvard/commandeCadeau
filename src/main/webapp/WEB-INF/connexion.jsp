<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<jsp:include page="entete.jsp" />
	<h1>Connexion</h1>
	<c:if test="${nofication ne null}">
		<span style="color : red;">${notification}</span>
		<br>
	</c:if>

	<form action="connexion" method="POST">
		<label for="email">Email</label> 
		<input type="email" name="EMAIL"
			id="email" placeholder="Email"> <br>
		<label for="pwd">Password</label>
		<input type="password" name="PWD" id="pwd" placeholder="Password">
		<br>
		<button>Se connecter</button>
	</form>
</body>
</html>