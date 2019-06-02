<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="./" var="root" />
<!DOCTYPE html>
<html>
<head>
<title>Admin Applikasi Sumber Waras</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${root}resources/bootstrap/css/dataTables.bootstrap.css"
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
<script type="text/javascript" src="${root}resources/js/jadwal.js"></script>
</head>

<%@ include file="/resources/body/header.html"%>
<div class="col-md-11">
	<h1>Input Jadwal Dokter</h1>
	<form>
		<div class="form-group">
			<label>TraderID</label> <input type="text" class="form-control"
				id="traderId">
		</div>
		<div class="form-group">
			<label>CurrCode</label> <input type="text" class="form-control"
				id="currCode">
		</div>
		<div class="form-group">
			<label>BuySell</label> <input type="text" class="form-control"
				id="buySell">
		</div>
		<div class="form-group">
			<label>Amount</label> <input type="text" class="form-control"
				id="amount">
		</div>

		<!-- <div class="form-group">
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
		</div>    -->
		<button type="button" class="btn btn-primary" id="submitPasien">Save</button>
	</form>

	<div class="content-box-large">
		<div class="panel-heading">
			<div class="panel-title">Data Jadwal Dokter</div>
		</div>
		<div class="panel-body">
			<table cellpadding="0" cellspacing="0" border="0"
				class="table table-striped table-bordered" id="tableJadwal">
				<thead>
					<tr class="bg-info">
						<th>Trader ID</th>
						<th>currency code</th>
						<th>amount</th>
						<th>buysell</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listJadwal}" var="jadwal">
						<tr>
							<td>${jadwal.traderId}</td>
							<td>${jadwal.currencyCode}</td>
							<td>${jadwal.amount}</td>
							<td>${jadwal.BuySell}</td>
							<td><a data-id="${jadwal.id}"
								class="del btn btn-danger btn-sm" href="#">Delete</a> <a
								data-id="${jadwal.id}" class="upd btn btn-warning btn-sm"
								href="#">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="/resources/modal/jadwal-modal.html"%>
<%@ include file="/resources/body/footer.html"%>