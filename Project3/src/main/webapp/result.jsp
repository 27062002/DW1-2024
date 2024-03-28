<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,br.edu.ifsp.arq.ads.dw1s5.project3.model.Person"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Pessoas Cadastradas</title>
</head>
<body>
	<c:choose>
		<c:when test="${fn:length(personsList) > 0}">
			<table>
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>Email</th>
				</tr>
					<c:forEach var="person" items="${personsList}"
						varStatus="count">
					<tr>
						<td>${count.count}</td>
						<td>${person.name}</td>
						<td>${person.cpf}</td>
						<td>${person.email}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<c:out value="Nenhuma pessoa cadastrada."></c:out>
		</c:otherwise>
	</c:choose>
	
</body>
</html>