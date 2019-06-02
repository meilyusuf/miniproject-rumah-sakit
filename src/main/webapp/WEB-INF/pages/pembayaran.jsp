<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="./" var="root"></spring:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Pembayaran</title>
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
<script type="text/javascript"
	src="${root}resources/js/pembayaranscript.js"></script>
</head>
<%@ include file="/resources/body/header.html"%>
<h1>Pembayaran</h1>
<!-- ISI KONTEN -->
<div class="col-md-11">
	<div class="content-box-large">
		<form>
			<!-- <div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">No Transaksi</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="" placeholder="Masukkan ID Registrasi">
				</div>
			</div>  -->
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">ID Registrasi</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="idRegis"
						placeholder="Masukkan ID Registrasi Pasien">
				</div>
				<div class="col-sm-2">
					<button type="button" id="submitRegis" class="btn btn-primary">Submit</button>
				</div>
			</div>
			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Nama</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="nama" value="">
				</div>
			</div>
			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Umur</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="umur" value="">
				</div>
			</div>
			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Alamat</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="alamat" value="">
				</div>
			</div>
		</form>
		<!-- <form>
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">Id Check-Up</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="" placeholder="Masukkan ID Check-Up">
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</form>  -->

		<h3>Detail Obat yang di resep</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nama Obat</th>
					<th scope="col">Kuantitas</th>
					<th scope="col">Stok Obat</th>
					<th scope="col">Harga</th>
					<th scope="col">Total Harga</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody id="detilResep">
				<!-- <tr>
					<th scope="row">1</th>
					<td>Aspirin</td>
					<td>3</td>
					<td>10.000</td>
					<td>30.000</td>
					<td>
						<a data-id="" class="btn btn-primary btn-sm" href="">Edit</a>
						<a data-id="" class="btn btn-danger btn-sm" href="">Delete</a>
					</td>
				</tr>
 -->
				<!-- <tr>
					<td>Harga Total</td>
					<td></td>
					<td></td>
					<td></td>
					<td>60.000</td>
					<td></td>
				</tr> -->
			</tbody>
			<tfoot id="hargaTotalResep">
				<tr>
					<td>Harga Total</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>0</td>
					<td></td>
				</tr>
			</tfoot>
		</table>


		<h3>Detail Obat yang di beli</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nama Obat</th>
					<th scope="col">Kuantitas</th>
					<th scope="col">Harga</th>
					<th scope="col">Total Harga</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody id="detilPilihan">
				<!-- <tr>
					<td>Harga Total</td>
					<td></td>
					<td></td>
					<td></td>
					<td>60.000</td>
					<td></td>
				</tr> -->
			</tbody>
			<tfoot id="hargaTotalBeli">
				<tr>
					<td>Harga Total</td>
					<td></td>
					<td></td>
					<td></td>
					<td>0</td>
					<td></td>
				</tr>
			</tfoot>
		</table>
		<button id="finalSubmit" class="del btn btn-success">Submit</button>
	</div>
</div>

<%@ include file="/resources/body/footer.html"%>