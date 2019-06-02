$(document).ready(function(){
	
	document.getElementById('inputDate').valueAsDate = new Date();
	
	//submit pasien
/*	$('#pasien-submit').on('click', function(){
		var id = $('#pasien-id').val();
		$.ajax({
			url: 'registrasi/getpasien/'+id,
			success: function(pasien){
				_setFormModalUpdate(pasien);
			},error: function(){
				alert('failed load data');
			}
		});
		
	});*/
	$('#kode-submit').on('click', function(){
		var searchKode = $('#pasien-kode').val();
		var pasien = {
			kodePasien : searchKode
		}
		if(searchKode == "") {
			alert('mohon Isi Kode Registrasi terlebih dahulu')
			return false;
		}
		console.log(pasien);
		$.ajax({
			url: 'registrasi/getKodePasien',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(pasien),
			success: function(data){
				console.log(data);
				setValuePasien(data);
			},error: function(){
				alert('Mohon Masukkan Kode Pasien Yang Benar');
			}
		});
		
	});
	//set form update data
	function setValuePasien(pasien) {
		$('#pasien-id').val(pasien.id);
		$('#nama-pasien').val(pasien.name);
		$('#umur-pasien').val(pasien.umur);
		$('#alamat-pasien').val(pasien.alamat);
	}
	
	
	$('.slc').on('click', function() {
		var dataTr = $(this).parents('tr'); //ngambil data dulu
		var jadwalId =  $(this).attr('data-id');
		var jadwal = {
				id: jadwalId,
				name : dataTr.find('td').eq(1).text(),
				spesialis : dataTr.find('td').eq(2).text(),
				hari : dataTr.find('td').eq(3).text(),
				jamPraktek : dataTr.find('td').eq(4).text()
				
		}
		appendSelectionData(jadwal);
		dataTr.remove();
	/*	console.log(jadwal);*/
	});
	
	function appendSelectionData(jadwal) {
		var tableselect = $('#table-selection');
		var bodyTable = tableselect.find('tbody');
		var trData = "<tr data-id='"+jadwal.id+"'>";
				trData+= "<td>";
					trData+= jadwal.id;
				trData += "</td>";
				trData+= "<td>";
					trData+= jadwal.name;
				trData += "</td>";
				trData+= "<td>";
					trData+= jadwal.spesialis;
				trData += "</td>";
				trData+= "<td>";
					trData+= jadwal.hari;
				trData += "</td>";
				trData+= "<td>";
					trData+= jadwal.jamPraktek;
				trData += "</td>";
				trData+= "<td>";
					trData+= "<a class='btn btn-danger hapus-item'>hapus</a>";
				trData += "</td>";
			trData += "</tr>";
			bodyTable.append(trData);	
	}
	
	// ini untuk nge save
	$('#submitfinal').on('click', function() {
		var str = $('#nama-pasien').val();
	    var res1 = str.substring(0, 1);
	    var res2 = str.substring(3, 4);
		var randomNumber = Math.floor(Math.random() * 1000);
		var generateKode = "R"+res1+randomNumber+res2;
		console.log(generateKode);
		var registrasi = {
				detailRegist : [],
				date : Date.parse($('#inputDate').val()),
				kodeRegist : generateKode,
				pasien : {
					id : $('#pasien-id').val(),
					name : $('#nama-pasien').val()
				}
		}
		
		
		var oTable = $('#table-selection').find('tbody');
		var dataDetail = [];
		$.each(oTable.find('tr'), function(index, data)	{
			var jadwalId = $(this).attr('data-id');
			var detailJadwal = {
						jadwalPraktek : {
							id : jadwalId,
							hari : $(this).find('td').eq(3).text(),
							jamPraktek : $(this).find('td').eq(4).text(),
							dokter : {
							name : $(this).find('td').eq(1).text(),
							spesialis : $(this).find('td').eq(2).text(),
							}
						}
			};
			registrasi.detailRegist.push(detailJadwal);
			/*dataDetail.push(detailJadwal);*/
		});
		
		console.log(registrasi);
		$.ajax({
			url : 'registrasi/saveregistrasi',
			type : 'POST',
			data : JSON.stringify(registrasi),
			contentType : "application/json",
			success: function(data) {
				console.log(data);
				alert('data telah sukses di simpan');
				setValueRegis(data);
				/*window.location="registrasi";*/
				
				
			},error : function() {
				alert('data gagal disimpan');
			}		
		});
		
		function setValueRegis(registrasi) {
			$('#kode-regist').val(registrasi.kodeRegist);
			$('#tgl-regist').val(registrasi.date);
			pasien : {
				$('#det-pasien').val(registrasi.pasien.name);
			}
			detailRegist : []
		}
		
	});
	$('#print').on('click', function() {
		window.location="registrasi"
	});
});