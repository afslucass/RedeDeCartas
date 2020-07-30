<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">
    <%-- <link rel="stylesheet" href="css/home_css.css"> --%>
    <link rel="stylesheet" href="css/hm.css">
    <title>Home</title>
</head>
<body>
    <c:import url="nav.jsp" />
    <h1>Postagens</h1>

    <section id="posts">
        <%-- <article>
            <div id="foto">
                <img src="data:image/jpeg;charset=utf-8;base64,${item.image}" alt="foto">
            </div>
            <div id="nick">${item.nick}</div>
            <div id="descricao">${item.message}</div>
            <button>Visualizar</button>
        </article> --%>
    </section>

    <script src="js/ajax/ajax_home.js"></script>
</body>
</html>