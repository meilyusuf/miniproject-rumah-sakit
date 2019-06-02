$(document).ready(function(){
	
	$('#submitPasien').on('click', function(){
		//validasi
		
	    //generate kode
		
		var transaksi = {
				
				
				currencyCode :$('#currCode').val(),
				BuySell : $('#buySell').val(),
				amount :$('#amount').val(),
				traderId : $('#traderId').val(),
		}	
		console.log(transaksi);
		
			$.ajax({
			url : 'pasien/save',
			type: 'post',
			data: JSON.stringify(transaksi),
				contentType: 'application/json',
			success: function(){
					window.location="jadwalPraktek"
				},
			error: function(){
					alert('data telah gagal disimpan');
				}
			})
	});
	//event untuk button delet
	$('.del').on('click', function(){
		//alert('will delete the record..!');
		var conf = confirm("are your sure delete data ?");
		var id = $(this).attr('data-id');
		console.log(id);
		if(conf){
			//ajax (Asyncronous JavaScript and XML)
			$.ajax({
				url : 'jadwalPraktek/delete/'+id,
				type: 'GET',
				success: function(data){
				    window.location="jadwalPraktek"
				}, error: function(){
					alert('Jadwal Ini Diambil Oleh Pasien Yang Registrasi');
				}
			});
		}
		return false;
	});
	
	//event untuk update
	$('.upd').on('click', function(){
		var id = $(this).attr('data-id');
		$.ajax({
			url: 'jadwalPraktek/get/'+id,
			type: 'GET',
			success: function(jadwalPraktek){
				console.log(jadwalPraktek);
				_setFormModalUpdate(jadwalPraktek);
			},error: function(){
				alert('failed load data');
			}
		});
		$('#modal-data-edit').modal();
	});
	
	$('#btn-change').on('click', function(){
		var jadwal = _getFormModalUpdate();
		console.log(jadwal);
		$.ajax({
			url : 'jadwalPraktek/update',
			type: 'PUT',
			data: JSON.stringify(jadwal),
			contentType: "application/json",
			success: function(){
				window.location="jadwalPraktek";
	
			},error : function(){
				console.log('data gagal diubah!!');
			}
		});
		
	});
	function _setFormModalUpdate(jadwalPraktek){
		$('#jadwal-idM').val(jadwalPraktek.id);
		$('#select-dokterM').val(jadwalPraktek.dokter.id).prop('selected', true);
		$('#inputHariM').val(jadwalPraktek.hari);
		$('#inputJamPraktekM').val(jadwalPraktek.jamPraktek);
	}
	//get form update data
	function _getFormModalUpdate(){
		return jadwalPraktek = {
				id : $('#jadwal-idM').val(),
				hari : $('#inputHariM').val(),
				jamPraktek : $('#inputJamPraktekM').val(),
				dokter : {
					id : $('#select-dokterM').val()
				}
		}
	}
});