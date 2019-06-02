<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="./" var="root" />

<!DOCTYPE html>
<html>
<head>
<title>Registrasi Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
	src="${root}resources/js/pembayaranAdmscript.js"></script>
</head>
<%@ include file="/resources/body/header.html"%>
<!-- ISI KONTEN -->
<div class="col-md-11">
	<h1>Pembayaran Administrasi</h1>
	<form>
		<div class="form-group row">
			<label for="" class="col-sm-2 col-form-label">ID Registrasi</label>
			<div class="col-sm-8">
				<!-- <input type="text" class="form-control" id="idRegis" placeholder="Masukkan id Registrasi">  -->
				<select class="form-control" id="idRegis">
					<c:forEach items="${listRegist}" var="regist">
						<option value="${regist.id}">${regist.id} , ${regist.pasien.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-sm-2">
				<button type="button" class="btn btn-primary" id="submitRegis">Submit</button>
			</div>
		</div>
		<div class="form-group row">
			<label for="staticEmail" class="col-sm-2 col-form-label">Nama
				Pasien</label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext" id="nama"
					value="">
			</div>
		</div>
		<div class="form-group row">
			<label for="staticEmail" class="col-sm-2 col-form-label">Umur</label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext" id="umur"
					value="">
			</div>
		</div>
		<div class="form-group row">
			<label for="staticEmail" class="col-sm-2 col-form-label">Alamat</label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext"
					id="alamat" value="">
			</div>
		</div>
		<div class="form-group row">
			<label for="" class="col-sm-2 col-form-label">Tanggal
				Pembayaran</label>
			<div class="col-sm-8">
				<input type="date" class="form-control" id="CurrentDate"
					placeholder="Masukkan ID Check-Up">
			</div>
		</div>
	</form>
	<div class="content-box-large">
		<div class="panel-heading">
			<div class="panel-title">Biaya</div>
		</div>
		<div class="panel-body">
			<table cellpadding="0" cellspacing="0" border="0"
				class="table table-striped table-bordered" id="table-pembayaran">
				<thead>
					<tr>
						<th scope="col">ID CheckUp</th>
						<th scope="col">Detail Pembayaran</th>
						<th scope="col">Nama Dokter</th>
						<th scope="col">Diagonosa</th>
						<th scope="col">Harga</th>
						<th scope="col">Tgl-CheckUp</th>
						<th scope="col">Total Harga</th>
					</tr>
				</thead>
				<!-- <tbody>
				<tr>
					<td>Dokter Siapa</td>
					<td>Dr. Hadi , checkUp</td>
					<td>125000</td>
					<td></td>
					<td>125000</td>
				</tr>
				<tr>
					<td></td>
					<td>Kamar Vip</td>
					<td>50000</td>
					<td><input type="number" id="" name="" value="" required aria-required="true"></td>
					<td>150000</td>
				</tr>
				<tr>
					<td>Total Biaya</td>
					<td></td>
					<td></td>
					<td></td>
					<td>1.0000000</td>
				</tr>
			</tbody> -->
				<tbody id="detilPembayaran">
				</tbody>
				<tfoot id="hargaTotal">

				</tfoot>
			</table>
		</div>
	</div>
	<button type="button" class="btn btn-primary" id="submitfinal">Submit</button>
</div>
<!-- ISI KONTEN -->
<%@ include file="/resources/body/footer.html"%>