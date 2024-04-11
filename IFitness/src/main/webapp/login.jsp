<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="pt-BR">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link href="css/login.css" rel="stylesheet">

    <title>IFitness - Página de login</title>
  </head>
  <body>
  	<div class="container">
    	<div class="col-lg-4 offset-lg-4 col-sm-12">
    	<c:if test="${result == 'registered' }">
    		<div class="alert alert-success alert-dismissible fade show" role="alert">
  			<strong>Usuário cadastrado com sucesso. Faça o login.</strong> You should check in on some of those fields below.
  			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
    	</c:if>
    	 <form action="login" method="post">
    	 		<h1 class="text-center">Login</h1>
    	 		
    	 		<div class="input-group mb-3">
  					<span class="input-group-text">
  						<img alt="ícone de e-mail" src="img/envelope.svg">
  					</span>
  					<input type="email" class="form-control" placeholder="E-mail" aria-label="E-mail" name="email" id="email">
				</div>
				
				<div class="input-group mb-3">
  					<span class="input-group-text">
  						<img alt="ícone de senha" src="img/file-lock.svg">
  					</span>
  					<input type="password" class="form-control" placeholder="Senha" aria-label="Senha" name="password" id="password">
				</div>
				
				<button type="submit" class="btn btn-primary mb-3">Entar</button>
				<a href="user-register.jsp" class="btn btn-secondary">Cadastrar</a>
    	 </form>
    	</div>
    </div>

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </body>
</html>