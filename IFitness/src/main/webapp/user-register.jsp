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
	<link href="css/user-register.css" rel="stylesheet">

    <title>IFitness - Página de Cadastro de Usuário</title>
  </head>
  <body>
  	<div class="container">
    	<div class="col-lg-6 offset-lg-3 col-sm-12">
    	 <form action="login" method="post">
    	 		<h1 class="text-center">Cadastre-se</h1>
    	 		
    	 		<div class="mb-2">
					<label for="name">Nome completo*</label>
  					<input type="text" class="form-control" name="name" id="name" minlenght="3" maxlength="50"
  					required="required">
  					<span id="0"></span>
				</div>
				
				<div class="mb-2">
					<label for="email">E-mail*</label>
  					<input type="email" class="form-control" name="email" id="email"
  					required="required">
  					<span id="1"></span>
				</div>
				
				<div class="mb-2">
  					<label for="password">Senha*</label>
  					<input type="password" class="form-control" name="password" id="password" minlenght="6" maxlength="12" required="required">
  					<span id="2"></span>
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