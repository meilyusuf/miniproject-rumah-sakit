$(document).ready(function(){
		
	$('#submitRegis').on('click',function(){
		
		$('.hideListKamar').removeAttr("style");
		$('#pilihanKamarAtas').find('th').eq(5).removeAttr("style");
		$('.listKamar').remove();
		$('#pilihanKamar').find('tr').remove();
		
		if($('#pilihanObat').children().length!=0){
			$.each($('#pilihanObat').find('tr'),function(){
				var id = $(this).find('button').attr('data-id');
				var nama = $(this).find('td').eq(0).text();
				
				$('#daftarObat').append("<tr>" +
						"<th scope=row>"+id+"</th>" +
						"<td>"+nama+"</td>" +
						"<td><input type=number class=kuantitasObat></td>" +
						"<td>" +
						"<button type=button data-id="+id+" class='tambah btn btn-primary btn-sm'>Tambah</button>" +
						"</td>" +
						"</tr>");
				$(this).remove();
			})
		}
		
		var id = $('#idRegis').val();
		
		$.ajax({
			url:'checkup/get/'+id,
			type:'get',
			data:JSON.stringify(id),
			contentType:'application/json',
			success:function(data){
				$('#hasilNamaRegis').val(data.name);
			},
			error:function(){
				alert('mohon masukkan ID registrasi yang benar')
			}
		})
		
		$.ajax({
			url:'checkup/cekDetilKamarByRegis/'+id,
			type:'get',
			data:JSON.stringify(id),
			contentType:'application/json',
			success:function(kamar){
				console.log(kamar);
				if(kamar.id!=0){
					$('.hideListKamar').attr("style","display: none;");
					$('#pilihanKamar').find('td').eq(4).attr("style","display: none;");
					$('#pilihanKamarAtas').find('th').eq(5).attr("style","display: none;");
					
					var idKamar=kamar.id;
					var noKamar=kamar.noKamar;
					var lantaiKamar=kamar.lantai;
					var kuotaKamar=kamar.kuota;
					var tipeKamar=kamar.tipe;
					var jenisKamar;
					if(tipeKamar==1){
						jenisKamar='Biasa';
					}else if(tipeKamar==2){
						jenisKamar='VIP';
					}
					$('#pilihanKamar').append("<tr class=listKamar data-id="+tipeKamar+">" +
							"<th scope=row>"+idKamar+"</th>" +
							"<td>"+noKamar+"</td>" +
							"<td>"+lantaiKamar+"</td>" +
							"<td>"+jenisKamar+"</td>" +
							"<td>"+kuotaKamar+"</td>" +
							"<td>" +
							"<button type=button class='hideListKamar btn-primary btn-md' value=double>Pilih</button>" +
							"</td>" +
							"</tr>");
				}
			},
			error:function(){
				alert('gagal')
			}
		})
		
	})
	
	$('#rawatInap').on('click',function(){
		$(this).closest('.collapse-group').find('.collapse').collapse('show');
	})
	
	$('#rawatJalan').on('click',function(){
		$(this).closest('.collapse-group').find('#collapseRawatInap').collapse('hide');
		$(this).closest('.collapse-group').find('#collapseRawatJalan').collapse('show');
		var tRListKamar=$('#listKamar').find('tr');
		var tRPilihanKamar=$('#pilihanKamar').find('tr');
		tRListKamar.remove();
		tRPilihanKamar.remove();
	})
	
	//buat search tipe kamar
	$(document).on('click','#pilihKamar',function(){
		
		var tipe=$('#tipeKamar').val();
		$.ajax({
			url:'checkup/getKamarByTipe/'+tipe,
			type:'get',
			data:JSON.stringify(tipe),
			contentType:'application/json',
			success:function(kamar){
//				console.log(kamar);
				$('.listKamar').remove();
				
				for(i=0;i<kamar.length;i++){
					var idKamar=kamar[i].id;
					var noKamar=kamar[i].noKamar;
					var lantaiKamar=kamar[i].lantai;
					var kuotaKamar=kamar[i].kuota;
					var tipeKamar=kamar[i].tipe;
					
					$('#listKamar').append("<tr class=listKamar data-id="+tipeKamar+">" +
							"<th scope=row>"+idKamar+"</th>" +
							"<td>"+noKamar+"</td>" +
							"<td>"+lantaiKamar+"</td>" +
							"<td>"+kuotaKamar+"</td>" +
							"<td>" +
							"<button type=button class='slc btn-primary btn-md'>Pilih</button>" +
							"</td>" +
							"</tr>")
					
				}
			},
			error:function(){
				alert('gagal pilih tipe kamar')
			}
		})
	})
	
	//buat bolak balik ke bawah
	$(document).on('click','.slc',function(){
		
		var id = $(this).attr('data-id');
		var tR=$(this).parent().parent();
		var idKamar=tR.find('th').text();
		var noKamar=tR.find('td').eq(0).text();
		var lantaiKamar=tR.find('td').eq(1).text();
		var kuotaKamar=tR.find('td').eq(2).text();
		var tipeKamar=tR.attr('data-id');
		var jenisKamar;
		if(tipeKamar==1){
			jenisKamar='Biasa';
		}else if(tipeKamar==2){
			jenisKamar='VIP';
		}

		if($('#pilihanKamar').children().length!=0){
			alert('mohon hapus yang sudah dipilih baru lakukan pemilihan kembali');
		}
		else{
			$('#pilihanKamar').append("<tr class=listKamar data-id="+tipeKamar+">" +
							"<th scope=row>"+idKamar+"</th>" +
							"<td>"+noKamar+"</td>" +
							"<td>"+lantaiKamar+"</td>" +
							"<td>"+jenisKamar+"</td>" +
							"<td>"+kuotaKamar+"</td>" +
							"<td>" +
							"<button type=button class='del btn-danger btn-md' >Hapus</button>" +
							"</td>" +
							"</tr>");
			tR.remove();
		}
	})
	
	$(document).on('click','.del',function(){
		
		var id = $(this).attr('data-id');
		var tR=$(this).parent().parent();
		var idKamar=tR.find('th').text();
		var noKamar=tR.find('td').eq(0).text();
		var lantaiKamar=tR.find('td').eq(1).text();
		var kuotaKamar=tR.find('td').eq(3).text();
		var tipeKamar=tR.attr('data-id');
		
		$('#listKamar').append("<tr class=listKamar data-id="+tipeKamar+">" +
				"<th scope=row>"+idKamar+"</th>" +
				"<td>"+noKamar+"</td>" +
				"<td>"+lantaiKamar+"</td>" +
				"<td>"+kuotaKamar+"</td>" +
				"<td>" +
				"<button type=button class='slc btn-primary btn-md' >Pilih</button>" +
				"</td>" +
				"</tr>");
		
		tR.remove();
	})
	
	$(document).on('click','.tambah',function(){
		var id = $(this).attr('data-id');
		var tR = $(this).parent().parent();
		var nama = tR.find('td').eq(0).text();
		var kuantitas =tR.find('.kuantitasObat').val();
		
		if(kuantitas==""){
			alert('mohon masukkan jumlah obatnya');
		}
		else{
			
			$('#pilihanObat').append("<tr>" +
					"<th scope=row>"+id+"</th>" +
					"<td>"+nama+"</td>" +
					"<td>"+kuantitas+"</td>" +
					"<td>" +
					"<button type=button data-id="+id+" class='hapusObat btn btn-danger btn-md'>Hapus</button>" +
					"</td>" +
					"</tr>");
			tR.remove();
		}
	})
	
	$(document).on('click','.hapusObat',function(){
		var id = $(this).attr('data-id');
		var tR = $(this).parent().parent();
		var nama = tR.find('td').eq(0).text();
		
		$('#daftarObat').append("<tr>" +
				"<th scope=row>"+id+"</th>" +
				"<td>"+nama+"</td>" +
				"<td><input type=number class=kuantitasObat></td>" +
				"<td>" +
				"<button type=button data-id="+id+" class='tambah btn btn-primary btn-sm'>Tambah</button>" +
				"</td>" +
				"</tr>");
		tR.remove();
		
	})
	
	
	$('#finalSubmit').on('click',function(){

		var tBodyObat=$('#pilihanObat');
		var listDetilObat=[];

		var tBodyKamar=$('#pilihanKamar');
		if(tBodyKamar.find('button').val()=='double'){
			tBodyKamar.find('tr').remove();
		}
		
		if(tBodyKamar.children().length==0){
			
			$.each(tBodyObat.find('tr'),function(){
				var id = $(this).find('th').text();
				var kuantitas = $(this).find('td').eq(1).text();
				
				var detilObat={
					obat:{
						id:id
					},
					quantity:kuantitas
				};
				
				listDetilObat.push(detilObat);
			})
			
			var checkup = {
				namaPenyakit: $('#penyakit').val(),
				tanggalCheckUp: new Date(),
				dokter: {
					id:$('#idDokter').val()
				},
				registrasi:{
					id:$('#idRegis').val()
				},
				listDetilObat:listDetilObat
			};
			
			$.ajax({
				url:'checkup/save',
				type:'post',
				data:JSON.stringify(checkup),
				contentType:'application/json',
				success:function(){
					window.location="checkup"
				},
				error:function(){
					alert("gagal save")
				}
			})
		}
		else{
			
			var id = tBodyKamar.find('th').text();
			
			var listDetilKamar=[];
			var detilKamar={
				kamar:{
					id:id
				}
			};
			listDetilKamar.push(detilKamar);
				
			$.each(tBodyObat.find('tr'),function(){
				var id = $(this).find('th').text();
				var kuantitas = $(this).find('td').eq(1).text();
				
				var detilObat={
					obat:{
						id:id
					},
					quantity:kuantitas
				};
				
				listDetilObat.push(detilObat);
			})
			
			var checkup = {
				namaPenyakit: $('#penyakit').val(),
				tanggalCheckUp: new Date(),
				dokter: {
					id:$('#idDokter').val()
				},
				registrasi:{
					id:$('#idRegis').val()
				},
				listDetilObat:listDetilObat,
				listDetilKamar:listDetilKamar
			};
			
			$.ajax({
				url:'checkup/save',
				type:'post',
				data:JSON.stringify(checkup),
				contentType:'application/json',
				success:function(){
					window.location="checkup"
				},
				error:function(){
					alert("gagal save")
				}
			})
			
		}
	
	})
})