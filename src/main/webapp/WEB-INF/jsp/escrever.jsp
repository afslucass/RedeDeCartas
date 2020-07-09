<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/escrever_css.css">
    <title>-nOME AD AUTORA-</title>
</head>
<body>
    
    <c:import url="nav.jsp" />
    
    <nav>
        <h1>--nick da autora-- <br> --nick da nome conpleto--</h1>
    </nav>

    <section>
        <form name="form" action="#" method="POST" onclick="return validar()">
            <textarea name="text" cols="120" rows="60" placeholder="Escreva aqui"></textarea>
            <input type="submit" value="Enviar">
        </form>
    </section>
    
    <script src="../js/validate/validate_escrever.js"></script>
</body>
</html>