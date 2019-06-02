<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="./" var="root"></spring:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">
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
<script type="text/javascript" src="${root}resources/js/kamarscript.js"></script>

</head>
<body>
	<%@ include file="/resources/body/header.html"%>

	<div class="col-md-11">

		<h1>Form Kamar</h1>

		<form>
			<!-- action="kamar/save" method="post" -->
			<!-- <div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">ID Registrasi</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="idRegis" placeholder="Masukkan id Registrasi">
				</div>
			</div> -->
			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Lantai
					Kamar</label>
				<div class="col-sm-8">
					<input type="number" min=1 class="form-control" name="lantai"
						id="lantai" placeholder="Masukkan Lantai Kamar" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">Nomor Kamar</label>
				<div class="col-sm-8">
					<input type="number" min=1 class="form-control" name="noKamar"
						id="noKamar" placeholder="Masukkan Nomor Kamar" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">Tipe Kamar</label>
				<div class="col-sm-8">
					<select class="form-control" name="tipe" id="tipe" required>
						<option selected value="">--Pilih Tipe Kamar--</option>
						<option value="1">Biasa</option>
						<option value="2">VIP</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">Kuota Kamar</label>
				<div class="col-sm-8">
					<input type="number" min=1 class="form-control" name="kuota"
						id="kuota" placeholder="Masukkan Kuota Kamar" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">Harga Kamar</label>
				<div class="col-sm-8">
					<input type="number" min=1 class="form-control" id="harga"
						placeholder="Masukkan Harga Kamar" required>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-9"></div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-primary" id="submitKamar">Save</button>
				</div>
			</div>
		</form>
		<form>
			<div class="form-group row">
				<div class="card card-body">
					<h2 class="hideListKamar">List Kamar</h2>
					<table class="hideListKamar table table-striped">
						<thead id="listKamarAtas">
							<tr>
								<th scope="col">ID</th>
								<th scope="col">No. Kamar</th>
								<th scope="col">Lantai Kamar</th>
								<th scope="col">Kuota Kamar</th>
								<th scope="col">Harga Kamar</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody id="listKamar">
							<c:forEach items="${listKamar}" var="kamar">
								<tr>
									<th scope="row">${kamar.id}</th>
									<td>${kamar.noKamar}</td>
									<td>${kamar.lantai}</td>
									<td>${kamar.kuota}</td>
									<td style="display: none;">${kamar.tipe}</td>
									<td>${kamar.harga}</td>
									<td>
										<button type="button" data-id="${kamar.id}"
											class="slc btn btn-primary btn-sm">Edit</button>
										<button type="button" data-id="${kamar.id}"
											class="del btn btn-danger btn-sm">Delete</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	</div>


	<%@ include file="/resources/body/footer.html"%>