$(document).ready(function(){
	
	$('#submitPasien').on('click', function(){
		//validasi
		var valname = $('#inputName1').val();
		var valumur = $('#inputUmur1').val();
		var valalamat = $('#inputAlamat1').val();
		var valemail = $('#inputEmail1').val();
		if(valname==""){
			alert('mohon masukkan Nama Pasien')
			return false;
		}
		if(valumur==""){
			alert('mohon masukkan Umur pasien')
			return false;
		}
		if(valalamat==""){
			alert('mohon masukkan Alamat Pasien')
			return false;
		}
		if(valemail==""){
			alert('mohon masukkan Email Pasien')
			return false;
		}
	    //generate kode
		var str = $('#inputName1').val();
	    var res = str.substring(0, 4);
		var randomNumber = Math.floor(Math.random() * 10000);
		var generateKode = "P"+res+ randomNumber;
		var trader = {
				id :$('#idPasien1').val(), 
				traderName :$('#inputName1').val(),
				traderId : generateKode
		}	
		console.log(trader);
		
			$.ajax({
			url : 'pasien/save',
			type: 'post',
			data: JSON.stringify(trader),
				contentType: 'application/json',
			success: function(){
					window.location="pasien"
				},
			error: function(){
					alert('data telah gagal disimpan');
				}
			})
	});
	
	//event button delete
	$('.del').on('click',function(){
		//alert('akan menghapus ?');
		var conf=confirm("are you sure to delete data ?");
		var id =$(this).attr('data-id');
		if(conf){
			//ajax (Asyncronous Javascript and XML)
			$.ajax({
				url : 'pasien/delete/'+id,
				type: 'GET',
				success: function(pasien){
					window.location="pasien"
				},error: function(){
					alert('Pasien ini Telah Terdaftar');	
				}
			})
		}
		return false;
	});
	
	//event button edit
	$('.upd').on('click', function(){
		var id =$(this).attr('data-id');
		$.ajax({
			url : 'pasien/get/'+id,
			type: 'GET',
			success: function(pasien){
				setFormModalUpdate(pasien);
			},error: function(){
			alert('failed load data');
			
			}
		});
		$('#modal-data-edit').modal();	
	});
	//button update
	$('#btn-change').on('click', function(){
		var pasien = getFormModalUpdate();
		console.log(pasien);
		$.ajax({
			url : 'pasien/update',
			type: 'POST',
			data: JSON.stringify(pasien),
			contentType: 'application/json',
			success: function(data){
				window.location="pasien";
			},error: function(){
			alert('failed');
			
			}
		});
		/* $('#modal-data-edit').modal('hide'); */
	});
	//set form update data
	function setFormModalUpdate(pasien){
		$('#pasien1-id').val(pasien.id)
		$('#inputName').val(pasien.name);
		$('#inputUmur').val(pasien.umur);
		$('#inputAlamat').val(pasien.alamat);
		$('#inputKodePasien').val(pasien.kodePasien);
	}
	//get form update data
	function getFormModalUpdate(){
		return pasien = {
			 	id :$('#pasien1-id').val(), 
				name :$('#inputName').val(),
				umur :$('#inputUmur').val(),
				alamat :$('#inputAlamat').val(),
				kodePasien : $('#inputKodePasien').val()
		}
		
	}
	
});