<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="./" var="root" />
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Admin Theme v3</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${root}resources/bootstrap/css/dataTables.bootstrap.css"
	rel="stylesheet" media="screen">
<link
	href="https://code.jquery.com/ui/1.10.3/themes/redmond/jquery-ui.css"
	rel="stylesheet" media="screen">
<!-- Bootstrap -->
<link href="${root}resources/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<!-- styles -->
<link href="${root}resources/css/styles.css" rel="stylesheet">
<link href="${root}resources/css/custom.css" rel="stylesheet">
<!-- Javascript -->
<script type="text/javascript"
	src="${root}resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${root}resources/js/pasienscript.js"></script>
</head>

<%@ include file="/resources/body/header.html"%>
<div class="col-md-11">
	<h1>Input Data Pasien</h1>
	<form>
		<div class="form-group">
			<input type="hidden" class="form-control" id="idPasien1"> 
			<label>Name</label>
			<input type="text" name="name" class="form-control" id="inputName1">
		</div>
		<div class="form-group">
			<label>Umur</label>
			<input type="number"  class="form-control" id="inputUmur1">
		</div>
		<div class="form-group">
			<label>Alamat</label>
			<input type="text" name="alamat" class="form-control" id="inputAlamat1">
		</div>
		 <div class="form-group">
			<label>Alamat Email</label>
			<input type="email" class="form-control" id="inputEmail1">
		</div>
		<button type="button" class="btn btn-primary" id="submitPasien">Save</button>
	</form>

	<p />
	<hr />

	<div class="content-box-large">
		<div class="panel-heading">
			<div class="panel-title">Data Pasien</div>
		</div>
		<div class="panel-body">
			<table cellpadding="0" cellspacing="0" border="0"
				class="table table-striped table-bordered" id="tablePasien">
				<thead>
					<tr class="bg-info">
						<th>Kode Pasien</th>
						<th>Nama</th>
						<th>Umur</th>
						<th>Alamat</th>
						<th>Email</th>
	
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listPasien}" var="pasien">
						<tr>
							<td>${pasien.kodePasien}</td>
							<td>${pasien.name}</td>
							<td>${pasien.umur}</td>
							<td>${pasien.alamat}</td>
							<td>${pasien.email}</td>							
							<td><a data-id="${pasien.id}"
								class="del btn btn-danger btn-sm" href="#">Delete</a> <a
								data-id="${pasien.kodePasien}" class="upd btn btn-warning btn-sm"
								href="#">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="/resources/modal/pasien-modal.html"%>
<%@ include file="/resources/body/footer.html"%>