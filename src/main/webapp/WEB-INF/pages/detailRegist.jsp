<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="./" var="root" />
<!DOCTYPE html>
<html>
<head>
<title>Admin Applikasi Sumber Waras</title>
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
</head>

<%@ include file="/resources/body/header.html"%>
<div class="col-md-11">
	<div class="content-box-large">
		<div class="panel-heading">
			<div class="panel-title">Data Registrasi</div>
		</div>
		<div class="panel-body">
			<table cellpadding="0" cellspacing="0" border="0"
				class="table table-striped table-bordered" id="tableDetailRegist">
				<thead>
					<tr class="bg-info">
						<th>ID Registrasi</th>
						<th>Kode Registrasi</th>
						<th>Nama pasien</th>
						<th>Tanggal Registrasi</th>
						<th>Daftar Jadwal Dokter</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listRegist}" var="regist">
						<tr>
							<td>${regist.id}</td>
							<td>${regist.kodeRegist}</td>
							<td>${regist.pasien.name}</td>
							<td>${regist.date}</td>
							<td>
								<ul class="list-group">
									<c:forEach items="${listDetailRegist}" var="detail">
										<li class="list-group-item active">${detail.jadwalPraktek.dokter.name}
											, ${detail.jadwalPraktek.hari},
											${detail.jadwalPraktek.jamPraktek}</li>
									</c:forEach>
								</ul>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="/resources/body/footer.html"%>