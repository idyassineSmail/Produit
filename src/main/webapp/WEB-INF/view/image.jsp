<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Creer un Produit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="./style.css">
</head>
<body><br>
<fieldset>
    <legend class="text-center">Creer un Produit</legend>
    <form action="uploadImage" method="post" enctype="multipart/form-data">
        <table class=" ">
            <tr>
                <td><label for="image">IMAGE: </label></td>
                <td><input type="file" name="image" id="image"></td>
            </tr>
            <tr>
                <td></td>
                    <input type="submit" class='btn btn-primary' value="ajouter"></td>
            </tr>
        </table>
    </form>
</fieldset>
<div class="text-center"><?php
        $url_springajouter = parse_url("http://$_SERVER[HTTP_HOST]$_SERVER[REQUEST_URI]");
        if(isset($url_springajouter['query'])){
        parse_str($url_springajouter['query'],$params);
        echo $params['message'];
        }
    ?></div>
</body>
</html>