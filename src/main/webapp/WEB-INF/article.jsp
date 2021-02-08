<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${article.designation}</title>
</head>
<body>
	<H1>${article.designation}</H1>

    <h2>${article.categorie.nom}</h2>

    <h3>nbPts : ${article.nbPoints}</h3>

    <h3>stock : ${article.stock}</h3>

    <h3>Commande passées : ${article.commandes.size()}</h3>

    <p>Description : ${article.description}</p>

    <form action="commande" method="POST">
        <label for="quantite"> Quantité</label>
        <input type="number" name="QUANTITE" id="quantite">
        <button>Commander</button>
    </form>
</body>
</html>