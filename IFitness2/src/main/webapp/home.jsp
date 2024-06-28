<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.util.List,br.edu.ifsp.arq.ads.ifitness.model.entities.Activity"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/home.css">
<title>iFitness - Página principal</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="ControllerServlet?action=listActivities">IFitness</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link" href="activity-register.jsp">Atividade</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#">Estatísticas</a>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            ${sessionScope.user.name}
	          </a>
	          <ul class="dropdown-menu">
	            <li><a class="dropdown-item" href="#">Minha Conta</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="ControllerServlet?action=logout">Sair</a>
	            </li>
	          </ul>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class="container">
		<div class="center col-lg-10 col-sm-12">
			<div class="col-12">
				<h1 class="text-center">Listagem de Atividades</h1>
			</div>
			<form action="ControllerServlet" method="post">
				<div class="row">
					<div class="col-12 col-lg-3">
					  	<div class="mb-2">
							<label for="type">Tipo</label> 
							<select class="form-select"
								name="type" id="type">
								<option value="" selected>Selecione</option>
								<option value="CAMINHADA">Caminhada</option>
								<option value="CICLISMO">Ciclismo</option>
								<option value="CORRIDA">Corrida</option>
								<option value="NATACAO">Natação</option>
							</select>
						</div>
					</div>
					<div class="col-12 col-lg-3">
						<div class="mb-2">
							<label for="initial-date">Data inicial</label> 
							<input type="date" name="initial-date" id="initial-date"
								class="form-control">
						</div>
					</div>  
					<div class="col-12 col-lg-3">
						<div class="mb-2">
							<label for="final-date">Data final</label>
							<input type="date" name="final-date" id="final-date"
								class="form-control">
						</div>
					</div>
					<div class="col-12 col-lg-3 mt-4">
						<button type="submit" class="btn btn-primary" name="action" value="searchActivities">Filtrar</button>
					</div>  
				</div>
			</form>
			<c:choose>
				<c:when test="${fn:length(userActivities) > 0}">
					<table class="table table-responsive table-striped table-hover" >
						<tr>
							<th>#</th>
							<th>Tipo</th>
							<th>Data</th>
							<th>Distância</th>
							<th>Duração</th>
							<th>Ações</th>
						</tr>
						<c:forEach var="activity" items="${userActivities}" varStatus="index">
							<tr>
								<td>${index.count}</td>
								<td>
									<c:choose>
										<c:when test="${activity.type == 'CORRIDA'}">
											<img src="icons/running_icon.png" alt="Corrida">
										</c:when>
										<c:when test="${activity.type == 'CAMINHADA'}">
											<img src="icons/walking_icon.png" alt="Corrida">
										</c:when>
										<c:when test="${activity.type == 'CICLISMO'}">
											<img src="icons/cycling_icon.png" alt="Corrida">
										</c:when>
										<c:when test="${activity.type == 'NATACAO'}">
											<img src="icons/swimming_icon.png" alt="Corrida">
										</c:when>
									</c:choose>
								</td>
								<td>
									<fmt:parseDate value="${activity.date}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
									<fmt:formatDate value="${parsedDate}" var="newParsedDate" type="date" pattern="dd/MM/yyyy" />
									${newParsedDate}
								</td>
								<td>${activity.distance}</td>
								<td>${activity.duration}</td>
								<td>
									<span data-bs-toggle="tooltip" data-bs-placement="top" title="Editar">
										<a class="btn" href="ControllerServlet?action=updateActivity&activity-id=${activity.id}">
	                						<img src="icons/pencil-square.svg" alt="Editar">
	                					</a>
									</span>
									
                					<span data-bs-toggle="tooltip" data-bs-placement="top" title="Excluir">
                						<a type="button" class="btn" data-bs-toggle="modal" data-bs-target="#myModal" data-bs-id="${activity.id}">
	                						<img src="icons/trash.svg" alt="Excluir">
	                					</a>
                					</span>
                					
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<c:out value="Sem nenhuma atividade registrada."></c:out>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal" tabindex="-1" id="myModal">
		<div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">Exclusão</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <p>Tem certeza que deseja excluir a atividade?</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
		        <a id="link" href="" class="btn btn-danger">Excluir</a>
		      </div>
		    </div>
	  	</div>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="js/home.js"></script>
</body>
</html>