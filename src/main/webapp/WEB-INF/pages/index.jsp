<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="./" var="root" />
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Admin Theme v3</title>
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
<%@ include file="/resources/body/header.html"%>
<h1>WELCOME TO DASHBORD ADMIN</h1>
<!-- ISI KONTEN -->

<!-- ISI KONTEN -->
<%@ include file="/resources/body/footer.html"%>