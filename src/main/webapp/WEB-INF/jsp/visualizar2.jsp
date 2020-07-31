<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/visualizar.css">
    <title>${nome}</title>
</head>
<body>
    
    <c:import url="nav.jsp" />
    <nav>
        <h1>${attributes.nick}<br>${nome}</h1>
        <div id="foto"><img src="data:image/jpeg;charset=utf-8;base64,${attributes.image}" alt="foto"></div>
    </nav>

    <section>
        ${attributes.message}
    </section>

    <script src="js/view_message/view_message.js"></script>
</body>
</html>