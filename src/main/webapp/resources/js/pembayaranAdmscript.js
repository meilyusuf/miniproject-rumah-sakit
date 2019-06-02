$(document).ready(function(){
	document.getElementById('CurrentDate').valueAsDate = new Date();
	
	$('#submitRegis').on('click',function(){
		var id = $('#idRegis').val();
		function setValueCheckUp(checkup) {
			$('#tgl-regist').val(checkup.tanggalCheckUp);
		}
		console.log(id);
		$.ajax({
			url:'pembayaran/get/'+id,
			type:'get',
			data:JSON.stringify(id),
			contentType:'application/json',
			success:function(data){
				$('#nama').val(data.name);
				$('#umur').val(data.umur);
				$('#alamat').val(data.alamat);
				
			},
			error:function(){
				alert('mohon masukkan ID registrasi yang benar')
			}
		})
		$.ajax({
			url:'pembayaranAdm/getCheckUp/'+id,
			tpye:'get',
			data:JSON.stringify(id),
			contentType:'application/json',
			success:function(data){
				console.log(data);
				var totalHarga=0;
				for(i=0;i<data.length;i++){
					var idCheckUp=data[i].id;
					var penyakit=data[i].namaPenyakit;
					var tglcheck=data[i].tanggalCheckUp;
					var idDokter=data[i].dokter.id;
					var namaDokter=data[i].dokter.name;
					var spesialis=data[i].dokter.spesialis;
					var biayaDokter=data[i].dokter.biaya;
				$('#detilPembayaran').append("<tr data-id="+idCheckUp+" class=detilPembayaran>" +
						"<td>"+idCheckUp+"</td>" +
						"<td>pembayaran checkup dokter spesialis : "+spesialis+"</td>" +
						"<td>dokter "+namaDokter+"</td>" +
						"<td>"+penyakit+"</td>" +
						"<td>"+biayaDokter+"</td>" +
						"<td> <input type='date' value="+tglcheck+"> </td>" +
						"<td>"+biayaDokter+"</td>" +
						"</tr>");
				totalHarga+=biayaDokter;
				}
				$('#hargaTotal').append("<tr>" +
						"<td>Total Harga</td>" +
						"<td></td>" +
						"<td></td>" +
						"<td></td>" +
						"<td></td>" +
						"<td></td>" +
						"<td><input type='text' id='totalHarga' value="+totalHarga+"></td>" +
						"</tr>");
			},
			error:function(){
				alert('gagal mendapatkan checkUp')
			}
		});
	});
	$('#submitfinal').on('click', function() {
		
		var pembayaranAdm = {
				detailcheckup : [],
				date : Date.parse($('#CurrentDate').val()),
				hargaTotal : $('#totalHarga').val()
		}
		var oTable = $('#table-pembayaran').find('tbody');
		var detailcheckup = [];
		$.each(oTable.find('tr'), function(index, data)	{
			var checkUpId = $(this).attr('data-id');
			var detailcheckup = {
					id : checkUpId,
			};
			pembayaranAdm.detailcheckup.push(detailcheckup);
		});
		console.log(pembayaranAdm);
		$.ajax({
			url : 'pembayaranAdm/savePembayaranAdm',
			type : 'POST',
			data : JSON.stringify(pembayaranAdm),
			contentType : "application/json",
			success: function(data) {
				console.log(data);
				alert('data telah sukses di simpan');
				/*window.location="registrasi";*/
			},error : function() {
				alert('detail gagal disimpan');
			}		
		});
	});
	

});	