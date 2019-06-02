$(document).ready(function(){
	
	$(document).on('click','.slc',function(){
		var id = $(this).attr('data-id');
		var tR = $(this).parent().parent();
		$(this).text('Submit');
		$(this).attr('class','update btn-success');
		tR.find('button').eq(1).text('Cancel');
		tR.find('button').eq(1).attr('class','batal btn-danger');
		var nama=tR.find('td').eq(0).text();
		var quantity=tR.find('td').eq(1).text();
		var harga=tR.find('td').eq(2).text();
		tR.find('td').eq(0).empty();
		tR.find('td').eq(1).empty();
		tR.find('td').eq(2).empty();
		tR.find('td').eq(0).append("<input type=text class=form-control placeholder="+nama+">");
		tR.find('td').eq(1).append("<input type=number min=0 class=form-control placeholder="+quantity+">");
		tR.find('td').eq(2).append("<input type=number min=0 class=form-control placeholder="+harga+">");
		
	})
	
	
	
	$(document).on('click','.update',function(){
		
		var tR = $(this).parent().parent();
		var id = $(this).attr('data-id');
		var nama=tR.find('input').eq(0).val();
		var quantity=tR.find('input').eq(1).val();
		var harga=tR.find('input').eq(2).val();
		var cekNama=tR.find('input').eq(0).attr('placeholder');
		
		var obat={
				id:id,
				nama:nama,
				harga:harga,
				quantity:quantity
		}
		
		var async = $.ajax({
			url:'obat/checkName/'+nama,
			type:'get',
			data:JSON.stringify(nama),
			contentType:'application/json',
			success:function(){
				
			},
			error:function(){
				alert('mohon masukkan nama')
			}
		})
		if(quantity==""){
			alert('mohon masukkan jumlah obat')
		}
		if(harga==""){
			alert('mohon masukkan harga obat')
		}
		if(quantity!="" && harga!="" && cekNama==nama){
			$.ajax({
				url:'obat/update',
				type:'post',
				data:JSON.stringify(obat),
				contentType:'application/json',
				success:function(){
					window.location="obat"
				},
				error:function(){
					alert('gagal update')
				}
			})
		}
		else if(quantity!="" && harga!=""){
			$.when(async).done(function(result){
				if(result==true){
					alert('nama sudah ada, mohon pilih nama yang lain')
				}
				else{
					$.ajax({
						url:'obat/update',
						type:'post',
						data:JSON.stringify(obat),
						contentType:'application/json',
						success:function(){
							window.location="obat"
						},
						error:function(){
							alert('gagal update')
						}
					})
				}
			})
		}	
	})
	
	$(document).on('click','.batal',function(){
		var id = $(this).attr('data-id');
		var tR = $(this).parent().parent();
		$(this).text('Delete');
		$(this).attr('class','del btn-danger');
		tR.find('button').eq(0).text('Edit');
		tR.find('button').eq(0).attr('class','slc btn-primary');
		var nama=tR.find('input').eq(0).attr('placeholder');
		var quantity=tR.find('input').eq(1).attr('placeholder');
		var harga=tR.find('input').eq(2).attr('placeholder');
		
		tR.find('td').eq(0).empty();
		tR.find('td').eq(1).empty();
		tR.find('td').eq(2).empty();
		tR.find('td').eq(0).append(nama);
		tR.find('td').eq(1).append(quantity);
		tR.find('td').eq(2).append(harga);
	})
	
	$(document).on('click','.del',function(){
		var tR = $(this).parent().parent();
		var id = $(this).attr('data-id');
		var nama=tR.find('td').eq(0).text();
		var quantity=tR.find('td').eq(1).text();
		var harga=tR.find('td').eq(2).text();
		
		var obat={
				id:id,
				nama:nama,
				harga:harga,
				quantity:quantity
		}
		
		$.ajax({
			url:'obat/delete',
			type:'post',
			data:JSON.stringify(obat),
			contentType:'application/json',
			success:function(){
				window.location="obat"
			},
			error:function(){
				alert('obat ini dirujuk dalam resep sehingga tidak dapat di delete')
			}
		})
	})
	
})