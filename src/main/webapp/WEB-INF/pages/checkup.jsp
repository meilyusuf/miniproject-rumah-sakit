<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="./" var="root"></spring:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Check-up</title>
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
	src="${root}resources/js/checkupscript.js"></script>
</head>
<%@ include file="/resources/body/header.html"%>

<!-- ISI KONTEN -->
<div class="col-md-11">

	<div class="content-box-large">
		<h1>Form Check Up</h1>
		<form>
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">ID Registrasi</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="idRegis"
						placeholder="Masukkan id Registrasi">
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-primary" id="submitRegis">Submit</button>
				</div>
			</div>
			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Nama
					Pasien</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="hasilNamaRegis" value="">
				</div>
			</div>
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">ID Dokter</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="idDokter"
						placeholder="Masukkan id Dokter">
				</div>
			</div>
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">Nama penyakit</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="penyakit"
						placeholder="Masukkan nama penyakit">
				</div>
			</div>
			<!-- <div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">Tanggal</label>
				<div class="col-sm-8">
					<input class="form-control" id="date" placeholder="MM/DD/YYY" type="text"/>
				</div>
			</div> -->
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">Penanganan</label>

				<div class="collapse-group col-sm-12">

					<a id="rawatInap" class="trigger collapsed btn btn-primary"
						data-toggle="collapse" href="" aria-expanded="false"
						aria-controls="collapseRawatJalan"> Rawat Inap </a> <a
						id="rawatJalan" class="trigger collapsed btn btn-primary"
						data-toggle="collapse" href="" aria-expanded="false"
						aria-controls="collapseRawatInap"> Rawat Jalan </a>

					<!-- collapse untuk rawat inap -->
					<div class="collapse" id="collapseRawatInap" aria-expanded="false">
						<div class="card card-body">
							<h2>Rawat Inap</h2>
							</p>
							<form>
								<div class="hideListKamar form-group row">
									<label for="tipeKamar" class="col-sm-2 col-form-label">Jenis
										Kamar</label>
									<div class="col-sm-8">
										<select class="custom-select" id="tipeKamar">
											<option value="0" selected>Pilih Kamar</option>
											<option value="1">Kamar Biasa</option>
											<option value="2">Rawat VIP</option>
										</select>
										<button type="button" id="pilihKamar"
											class="btn btn-primary btn-md">Pilih</button>
									</div>

								</div>
							</form>

							<h2 class="hideListKamar">List Kamar</h2>
							<table class="hideListKamar table table-striped">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">No. Kamar</th>
										<th scope="col">Lantai Kamar</th>
										<th scope="col">Kuota Kamar</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody id="listKamar">
									<%-- <c:forEach items="${listKamar}" var="kamar">
										<tr>
											<th scope="row"><input type="text" readonly class="${kamar.tipe} form-control-plaintext" value="${kamar.id}"></th>
											<td><input type="text" readonly class="${kamar.tipe} form-control-plaintext" value="${kamar.noKamar}"></td>
											<td><input type="text" readonly class="${kamar.tipe} form-control-plaintext" value="${kamar.lantai}"></td>
											<td>
												<button type="button" data-id="${kamar.id}" class="${kamar.tipe} slc btn btn-primary btn-sm">Tambah</button>
											</td>
										</tr>
									</c:forEach> --%>
								</tbody>
							</table>
							<h2>Detail Kamar yg di pilih</h2>
							<table class="table table-striped">
								<thead id="pilihanKamarAtas">
									<tr>
										<th scope="col">ID</th>
										<th scope="col">No. Kamar</th>
										<th scope="col">Lantai</th>
										<th scope="col">Jenis Kamar</th>
										<th scope="col">Kuota Kamar</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody id="pilihanKamar">

									<!-- <tr>
										<th scope="row"><input type="text" readonly class="form-control-plaintext" id="hasilIdKamar"></th>
										<td><input type="text" readonly class="form-control-plaintext" id="hasilNoKamar"></td>
										<td><input type="text" readonly class="form-control-plaintext" id="hasilTipe"></td>
										<td><input type="text" readonly class="form-control-plaintext" id="hasilLantai"></td>
										
										
										<td>
											<button type="button" id="hapus" class="dlt btn btn-danger btn-sm" href="">Hapus</a>
										</td>
									
									</tr> -->

								</tbody>
							</table>
							<!-- <a data-id="" class="del btn btn-success" href="">Submit</a> -->

						</div>
					</div>
					<!-- colllapse rawat inap penutup -->
					<div class="collapse" id="collapseRawatJalan" aria-expanded="false">
						<div class="card card-body">
							<h2>Resep</h2>
							</p>
							<h3>Daftar Obat</h3>
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">Nama Obat</th>
										<th scope="col">Kuantitas</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody id="daftarObat">

									<c:forEach items="${listobat}" var="obat">
										<tr>
											<th scope="row">${obat.id}</th>
											<td>${obat.nama}</td>
											<td><input type="number" min=1 class="kuantitasObat"></td>
											<td>
												<button type="button" data-id="${obat.id}"
													class="tambah btn btn-primary btn-sm" href="">Tambah</button>
											</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
							<h3>Detail Obat yang di pilih</h3>
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">Nama Obat</th>
										<th scope="col">Kuantitas</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody id="pilihanObat">
									<!-- <tr>
										<th scope="row"><input type="hidden" readonly="readonly" class="form-control-plaintext" value="id"></th>
										<td><input type="hidden" readonly="readonly" class="form-control-plaintext" value="nama"></td>
										<td><input type="hidden" readonly="readonly" class="form-control-plaintext" value="kuantitas"></td>
										<td>
											<button type="button" data-id="" class="btn btn-primary btn-sm">Edit</button>
										</td>
									</tr> -->
								</tbody>
							</table>
						</div>
					</div>

				</div>
			</div>

		</form>
		<button type="button" id="finalSubmit" class="btn btn-success">Submit</button>
		<!-- ISI KONTEN -->
	</div>
</div>
<%@ include file="/resources/body/footer.html"%>