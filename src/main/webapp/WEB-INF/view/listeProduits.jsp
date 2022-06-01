<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Liste Produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1 >Liste des Produits</h1>
<table >
    <tr>
        <th>ID</th><th>Nom Produit</th><th>Prix</th><th>Date Création</th><th>Suppression<th>Edition</th>
    </tr>
    <c:forEach items="${produits}" var="p">
        <tr>
            <td>${p.idProduit }</td>
            <td>${p.nomProduit }</td>
            <td>${p.prixProduit }</td>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.dateCreation}" /></td>
            <td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimerProduit?id=${p.idProduit}">Supprimer</a></td>
            <td><a href="modifierProduit?id=${p.idProduit }">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>