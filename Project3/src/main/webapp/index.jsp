<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Pessoas</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<form action="ServletPersons" method="post">
		<label for="persons">Dados das pessoas</label>
		<textarea rows="10" cols="80" name="persons" id="persons">
		</textarea>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>