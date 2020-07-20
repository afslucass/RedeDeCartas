 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- Importando a fonte: -->
	<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/nav_css.css">
</head>
<body>
	
	<nav class="nav">
		<div>
			<img src="data:image/jpeg;charset=utf-8;base64,${sessionScope.user_image}" alt="logo">
			<div>${sessionScope.user_attributes.nick}</div>
		</div>

		<p> <a href="action?mensagem=sair">LOGOUT</a> </p>
	</nav>
	<section class="section">
		<button onclick="location.href='action?mensagem=escrever'">Criar</button>
	</section>

</body>
</html>
