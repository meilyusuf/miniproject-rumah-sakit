<%@page import="java.util.List"%>
<%@page import="com.xsis.web128.entity.Pasien"%>
<%@page import="com.xsis.web128.entity.Dokter"%>
<%@page import="com.xsis.web128.entity.JadwalPraktek"%>
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
<script type="text/javascript" src="${root}resources/js/regscript.js"></script>
</head>
<%@ include file="/resources/body/header.html"%>

<!-- ISI KONTEN -->
<div class="col-md-11">
	<h1>Registrasi Pasien</h1>
	<form>
		<div class="form-group row">
			<label for="" class="col-sm-2 col-form-label">Kode Pasien</label>
			<div class="col-sm-8">
				<input id="pasien-kode" type="text" class="form-control"
					placeholder="Masukkan kode Pasien">
			</div>
			<div class="col-sm-2">
				<button type="button" class="btn btn-primary" id="kode-submit">Search</button>
			</div>
		</div>
		<div class="form-group row">
			<label for="staticEmail" class="col-sm-2 col-form-label">ID</label>
			<!-- <input type="hidden" id="pasien-id"/> -->
			<div class="col-sm-10">
				<input type="text" readonly class="form-control" id="pasien-id">
			</div>
		</div>
		<div class="form-group row">
			<label for="staticEmail" class="col-sm-2 col-form-label">Nama</label>
			<!-- <input type="hidden" id="pasien-id"/> -->
			<div class="col-sm-10">
				<input type="text" readonly class="pas-name form-control"
					id="nama-pasien">
			</div>
		</div>
		<div class="form-group row">
			<label for="staticEmail" class="col-sm-2 col-form-label">Umur</label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control" id="umur-pasien">
			</div>
		</div>
		<div class="form-group row">
			<label for="staticEmail" class="col-sm-2 col-form-label">Alamat</label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control" id="alamat-pasien">
			</div>
		</div>
		<div class="form-group row">
			<label for="" class="col-sm-2 col-form-label">Tanggal</label>
			<div class="col-sm-10">
				<input class="form-control" id="inputDate" type="date" />
			</div>
		</div>
	</form>
	<h2>Tabel Dokter</h2>
	<div class="content-box-large">
		<div class="panel-heading">
			<div class="panel-title">Tabel DokterTables</div>
		</div>
		<div class="panel-body">
			<table cellpadding="0" cellspacing="0" border="0"
				class="table table-striped table-bordered" id="registTable">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nama Dokter</th>
						<th scope="col">Spesialis</th>
						<th scope="col">hari</th>
						<th scope="col">Jam praktek</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listJadwal}" var="jadwal">
						<tr>
							<td>${jadwal.id 	}</td>
							<td>${jadwal.dokter.name}</td>
							<td>${jadwal.dokter.spesialis}</td>
							<td>${jadwal.hari}</td>
							<td>${jadwal.jamPraktek}</td>
							<td>
								<button data-id="${jadwal.id}"
									class="slc btn btn-primary btn-sm">tambah</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<h2>Pilih Jadwal Dokter</h2>
	<table class="table table-striped table-bordered" id="table-selection">
		<thead>
			<tr>
				<th scope="col">ID jadwal</th>
				<th scope="col">Nama Dokter</th>
				<th scope="col">Spesialis</th>
				<th scope="col">Hari</th>
				<th scope="col">Jadwal Praktik</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<div>
		<button type="button" class="btn btn-primary" id="submitfinal">Submit</button>
		<!-- <a href="#" class="btn btn-success" id="submitfinal" href="">Submit</a> -->
	</div>
	<h2>Detail Registrasi</h2>
	<div class="content-box-large">
		<div class="form-group row">
			<label for="staticEmail" class="col-sm-2 col-form-label">Kode
				Regist</label>
			<!-- <input type="hidden" id="pasien-id"/> -->
			<div class="col-sm-5">
				<input type="text" readonly class="pas-name form-control"
					id="kode-regist">
			</div>
			<div class="col-sm-2">
				<button type="button" class="btn btn-primary" id="print">Print</button>
			</div>
		</div>
		<div class="form-group row">
			<label for="staticEmail" class="col-sm-2 col-form-label">Nama
				Pasien</label>
			<div class="col-sm-5">
				<input type="text" readonly class="pas-name form-control"
					id="det-pasien">
			</div>
		</div>
		<div class="form-group row">
			<label for="staticEmail" class="col-sm-2 col-form-label">Tanggal
				Registrasi</label>
			<!-- <input type="hidden" id="pasien-id"/> -->
			<div class="col-sm-5">
				<input type="date" readonly class="pas-name form-control"
					id="tgl-regist">
			</div>
		</div>
		<%-- <table class="table table-striped table-bordered" id="detail-table">
			<thead>
				<tr>
					<th scope="col">Nama Dokter</th>
					<th scope="col">Spesialis</th>
					<th scope="col">Hari</th>
					<th scope="col">Jadwal Praktik</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${registrasi}" var="registrasi">
				<tr>
					<td>
					${registrasi.jadwal.dokter.name}
					</td>
					<td>
					${registrasi.jadwal.dokter.spesialis}
					</td>
					 <td>
					 ${registrasi.jadwal.hari}
					</td>
					 <td>
					 ${registrasi.jadwal.jamPraktek}
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>  --%>

	</div>
</div>
<!-- ISI KONTEN -->
<%@ include file="/resources/modal/modal-update.html"%>
<%@ include file="/resources/body/footer.html"%>