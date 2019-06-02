<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="./" var="root" />
<!DOCTYPE html>
<html>
<head>
<title>Login Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="${root}resources/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<!-- styles -->
<link href="${root}resources/css/styles.css" rel="stylesheet">
<link href="${root}resources/css/custom.css" rel="stylesheet">
<!-- Javascript -->
<script type="text/javascript"
	src="${root}resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${root}resources/js/regscript.js"></script>
</head>
<body class="login-bg">
	<div class="header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- Logo -->
					<div class="logo">
						<h1>
							<a href="index.html">Login Admin </a>
						</h1>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="page-content container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-wrapper">
					<div class="box">
						<div class="content-wrap">
							<h6>Sign In</h6>

							<input class="form-control" type="text" placeholder="Username">
							<input class="form-control" type="password"
								placeholder="Password">
							<div class="action">
								<a class="btn btn-primary signup" href="index.html">Login</a>
							</div>
						</div>
					</div>

					<div class="already">
						<p>Don't have an account yet?</p>
						<a href="http://localhost:8080/maven-project-128/index">Sign
							Up</a>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- ISI KONTEN -->

	<!-- ISI KONTEN -->