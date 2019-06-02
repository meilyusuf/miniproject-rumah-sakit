$(document).ready(function(){
	$('#submitRegis').on('click',function(){
		$('#detilResep').find('tr').remove();
		$('#detilPilihan').find('tr').remove();
		
		var id = $('#idRegis').val();
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
			url:'pembayaran/getDetilObat/'+id,
			tpye:'get',
			data:JSON.stringify(id),
			contentType:'application/json',
			success:function(data){
				console.log(data);
				var totalHarga=0;
				for(i=0;i<data.length;i++){
					var idDetilObat=data[i].id;
					var idCheckUp=data[i].checkup.id;
					var idObat=data[i].obat.id;
					var namaObat=data[i].obat.nama;
					var kuantitasObatResep=data[i].quantity;
					var hargaObat=data[i].obat.harga;
					var kuantitasStokObat=data[i].obat.quantity;
//					console.log(idDetilObat,idObat,namaObat,kuantitasObatResep,hargaObat)
					$('#detilResep').append("<tr data-id="+idCheckUp+" class=detilResep>" +
							"<th scope=row>"+idObat+"</th>" +
							"<td>"+namaObat+"</td>" +
							"<td>"+kuantitasObatResep+"</td>" +
							"<td>"+kuantitasStokObat+"</td>" +
							"<td>"+hargaObat+"</td>" +
							"<td>"+(kuantitasObatResep*hargaObat)+"</td>" +
							"<td><button type=button data-id="+idDetilObat+" class=pilihObat "+
							"value="+kuantitasObatResep+">Pilih</button></td>" +
							"</tr>");
					totalHarga+=(kuantitasObatResep*hargaObat);
				}
				
				$('#hargaTotalResep').find('tr').remove();
				$('#hargaTotalResep').append("<tr>" +
						"<td>Total Harga</td>" +
						"<td></td>" +
						"<td></td>" +
						"<td></td>" +
						"<td></td>" +
						"<td>"+totalHarga+"</td>" +
						"<td></td>" +
						"</tr>");
				
				$('#hargaTotalBeli').find('tr').remove();
				$('#hargaTotalBeli').append("<tr>" +
						"<td>Total Harga</td>" +
						"<td></td>" +
						"<td></td>" +
						"<td></td>" +
						"<td>0</td>" +
						"<td></td>" +
						"</tr>");
				
				var tBody=$('#detilResep');
				$.each(tBody.find('tr'),function(){
					var kuantitasObatResep=parseInt($(this).find('button').val());
					var kuantitasStokObat=parseInt($(this).find('td').eq(2).text());
					if(kuantitasStokObat<kuantitasObatResep){
						$(this).find('button').attr("style","display: none;");
					}
				})
				
			},
			error:function(){
				alert('gagal dapet detil obat')
			}
		})
		
	})
	
	$(document).on('click','.pilihObat',function(){
		
		var tR=$(this).parent().parent();
		var kuantitasObatResep=tR.find('button').val();
		var kuantitasStokObat=tR.find('td').eq(2).text();
		
		tR.find('td').eq(1).empty();
		tR.find('td').eq(1).append("<input type=number min=1 max="+kuantitasStokObat+" class=form-control " +
				"value="+kuantitasObatResep+">");
		$(this).text('Submit');
		$(this).attr("class","submitPilihObat");
		tR.find('td').eq(5).append("<button type=button class='batalPilihObat btn-danger btn-sm'>Cancel</button>");
		
	})
	
	$(document).on('click','.submitPilihObat',function(){
		
		var idDetilObat=$(this).attr('data-id');
		var tR=$(this).parent().parent();
		var idCheckUp=tR.attr('data-id');
		var idObat=tR.find('th').text();
		var namaObat=tR.find('td').eq(0).text();
		var kuantitasObatResep=tR.find('button').val();
		var hargaObat=tR.find('td').eq(3).text();
		var kuantitasStokObat=parseInt(tR.find('td').eq(2).text());
		
		var kuantitasPilihan=parseInt(tR.find('input').val());
		
		if(kuantitasPilihan>kuantitasStokObat){
			alert('jumlah yang anda pilih melebihi stok yang ada')
		}
		else{
			
			$('#detilPilihan').append("<tr data-id="+idCheckUp+" class=detilResep>" +
					"<th scope=row>"+idObat+"<input type=hidden value="+kuantitasStokObat+"></th>" +
					"<td>"+namaObat+"</td>" +
					"<td>"+kuantitasPilihan+"</td>" +
					"<td>"+hargaObat+"</td>" +
					"<td>"+(kuantitasPilihan*hargaObat)+"</td>" +
					"<td><button type=button data-id="+idDetilObat+" class=hapusObat "+
					"value="+kuantitasObatResep+">Hapus</button></td>" +
					"</tr>");
			
			tR.remove();
			
			var totalHarga=parseInt($('#hargaTotalResep').find('td').eq(5).text());
			totalHarga-=(kuantitasObatResep*hargaObat);
			
			$('#hargaTotalResep').find('tr').remove();
			
			$('#hargaTotalResep').append("<tr>" +
					"<td>Total Harga</td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td>"+totalHarga+"</td>" +
					"<td></td>" +
					"</tr>");
				
			var	totalHargaBeli=parseInt($('#hargaTotalBeli').find('td').eq(4).text());	
			totalHargaBeli+=(kuantitasPilihan*hargaObat);
			
			$('#hargaTotalBeli').find('tr').remove();
			
			$('#hargaTotalBeli').append("<tr>" +
					"<td>Total Harga</td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td>"+totalHargaBeli+"</td>" +
					"<td></td>" +
					"</tr>");
		}
	})
	
	$(document).on('click','.batalPilihObat',function(){

		var tR=$(this).parent().parent();
		var idDetilObat=tR.find('button').eq(0).attr('data-id');
		var kuantitasObatResep=tR.find('button').eq(0).val();
		
		tR.find('td').eq(1).empty();
		tR.find('td').eq(1).append(kuantitasObatResep);
		tR.find('td').eq(5).empty();
		tR.find('td').eq(5).append("<button type=button data-id="+idDetilObat+" class=pilihObat "+
						"value="+kuantitasObatResep+">Pilih</button>");
	})
	
	$(document).on('click','.hapusObat',function(){
		var idDetilObat=$(this).attr('data-id');
		var tR=$(this).parent().parent();
		var idCheckUp=tR.attr('data-id');
		var idObat=tR.find('th').text();
		var namaObat=tR.find('td').eq(0).text();
		var kuantitasObatResep=tR.find('button').val();
		var hargaObat=tR.find('td').eq(2).text();
		var kuantitasStokObat=tR.find('input').val();
		var kuantitasPilihan=tR.find('td').eq(1).text()
		
		$('#detilResep').append("<tr data-id="+idCheckUp+" class=detilResep>" +
				"<th scope=row>"+idObat+"</th>" +
				"<td>"+namaObat+"</td>" +
				"<td>"+kuantitasObatResep+"</td>" +
				"<td>"+kuantitasStokObat+"</td>" +
				"<td>"+hargaObat+"</td>" +
				"<td>"+(kuantitasObatResep*hargaObat)+"</td>" +
				"<td><button type=button data-id="+idDetilObat+" class=pilihObat "+
				"value="+kuantitasObatResep+">Pilih</button></td>" +
				"</tr>");
		tR.remove();
		
		var totalHarga=parseInt($('#hargaTotalResep').find('td').eq(5).text());
		totalHarga+=(kuantitasObatResep*hargaObat);
		
		$('#hargaTotalResep').find('tr').remove();
		
		$('#hargaTotalResep').append("<tr>" +
				"<td>Total Harga</td>" +
				"<td></td>" +
				"<td></td>" +
				"<td></td>" +
				"<td></td>" +
				"<td>"+totalHarga+"</td>" +
				"<td></td>" +
				"</tr>");
			
		var	totalHargaBeli=parseInt($('#hargaTotalBeli').find('td').eq(4).text());	
		totalHargaBeli-=(kuantitasPilihan*hargaObat);
		
		$('#hargaTotalBeli').find('tr').remove();
		
		$('#hargaTotalBeli').append("<tr>" +
				"<td>Total Harga</td>" +
				"<td></td>" +
				"<td></td>" +
				"<td></td>" +
				"<td>"+totalHargaBeli+"</td>" +
				"<td></td>" +
				"</tr>");
	})
	
	$('#finalSubmit').on('click',function(){
		var dataTable = $('#detilPilihan');
		var listDetilObat=[];
		var total=0;
		$.each(dataTable.find('tr'),function(){
			var idDetilObat=$(this).find('td').eq(4).find('button').attr('data-id');
			var idObat=$(this).find('th').text();
			var idCheckUp=$(this).attr('data-id');
			var kuantitasObatResep=$(this).find('button').val();
			var kuantitas=$(this).find('td').eq(1).text()
			total+=parseInt($(this).find('td').eq(3).text());
			var detilObat={
				id:idDetilObat,
				checkup:{
					id:idCheckUp
				},
				obat:{
					id: idObat
				},
				quantity:kuantitasObatResep,
				quantityObatDiBayar:kuantitas
			}
			listDetilObat.push(detilObat);
//			console.log(listDetilObat)
		})
		
		var pembayaran = {
			listDetilObat:listDetilObat,
			date:new Date(),
			hargaTotal:total
		}
		console.log(pembayaran);
		$.ajax({
			url:'pembayaran/savePembayaran',
			type:'post',
			data:JSON.stringify(pembayaran),
			contentType:'application/json',
			success:function(){
				window.location="pembayaran"
			},
			error:function(){
				alert('gagal save pembayaran')
			}
		})
	})
	
	
})