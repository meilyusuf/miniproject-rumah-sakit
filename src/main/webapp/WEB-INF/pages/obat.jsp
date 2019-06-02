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
<script type="text/javascript" src="${root}resources/js/obatscript.js"></script>
</head>
<body>
	<%@ include file="/resources/body/header.html"%>
	<div class="container">

		<h1>Form Obat</h1>

		<form action="obat/save" method="post">
			<!-- <div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">ID Registrasi</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="idRegis" placeholder="Masukkan id Registrasi">
				</div>
			</div> -->
			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Nama
					Obat</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="nama"
						placeholder="Masukkan Nama Obat" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">Quantity Obat</label>
				<div class="col-sm-8">
					<input type="number" min=0 class="form-control" name="quantity"
						placeholder="Masukkan Quantity Obat" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">Harga Obat</label>
				<div class="col-sm-8">
					<input type="number" min=1 class="form-control" name="harga"
						placeholder="Masukkan Harga Obat" required>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-9"></div>
				<div class="col-sm-2">
					<button type="submit" class="btn btn-primary" id="submitObat">Save</button>
				</div>
			</div>
		</form>
		<form>
			<div class="form-group row">

				<div class="col-sm-12">

					<div>
						<div class="card card-body">
							<h2 class="hideListKamar">List Obat</h2>
							<table class="hideListKamar table table-striped">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">Nama Obat</th>
										<th scope="col">Quantity Obat</th>
										<th scope="col">Harga Obat</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody id="listKamar">
									<c:forEach items="${listObat}" var="obat">
										<tr>
											<th scope="row">${obat.id}</th>
											<td>${obat.nama}</td>
											<td>${obat.quantity}</td>
											<td>${obat.harga}</td>
											<td>
												<button type="button" data-id="${obat.id}"
													class="slc btn btn-primary btn-sm">Edit</button>
												<button type="button" data-id="${obat.id}"
													class="del btn btn-danger btn-sm">Delete</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
					</div>


				</div>
			</div>

		</form>

	</div>
	<%@ include file="/resources/body/footer.html"%>