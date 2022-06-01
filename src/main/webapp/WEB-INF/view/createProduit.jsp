<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="windows-1256">
    <title> Creer un Produit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        h1{
            text-align: center;
            font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
        }

        fieldset{
            position: relative;
            border-radius: 5px;;
            border: none;
            width: 490px;
            margin: 20px auto;
            padding-top: 10px;
            text-align: center;
            background-color: #dcdde1;
        }
        label{
            position: relative;
            left: -15%;
            top: 3%;
            color:#0a0357;
        }
        legend{
            position: absolute;
            top: -9%;
            left: 4%;
            padding: 5px;
            font-size: small;
            width: 40%;
            font-weight: 800;
            border-radius: 5px;
            color: #0a0357;
            background-color: #cb997e;
            z-index: 3;
        }
    </style>
</head>
<body>
    <fieldset>
    <legend>Creer un Produit</legend>
        <form action="saveProduit" method="post">
        <pre>
            <label for="nom">NOM:</label>
            <input type="text" name="nomProduit" id="nom"/>
            <label for="prix">PRIX: </label>
            <input type="text" name="prixProduit" id="prix">
            <label for="date">DATE DE CRATION: </label>
            <input type="date" name="date" id="date">
            <label for="image">IMAGE: </label>
            <input type="file" name="image" id="image">
            <input type="submit" value="ajouter">
        </pre>
        </form>
    </fieldset>
    ${msg}
    <br/>
    <br/>
    <a href="ListeProduits">Liste Produits</a>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>