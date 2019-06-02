$(document).ready(function(){
	
	$('#submitKamar').on('click',function(){
		var lantai=$('#lantai').val()
		var noKamar=$('#noKamar').val()
		var tipe=$('#tipe').val()
		var kuota=$('#kuota').val()
		var harga=$('#harga').val()
		var kamar={
			lantai:lantai,
			noKamar:noKamar,
			tipe:tipe,
			kuota:kuota,
			harga:harga
		}
		console.log(kamar);
		$.ajax({
			url:'kamar/save',
			method:'post',
			data:JSON.stringify(kamar),
			contentType:'application/json',
			success:function(data){
				if(data==true){
					alert('data sudah ada')
				}else{
					window.location="kamar";
				}
			},
			error:function(){
				console.log('gagal coy')
			}
		})
	})
	
	$(document).on('click','.slc',function(){
		var id = $(this).attr('data-id');
		var tR = $(this).parent().parent();
		$(this).text('Submit');
		$(this).attr('class','update btn-success');
		tR.find('button').eq(1).text('Cancel');
		tR.find('button').eq(1).attr('class','batal btn-danger');
		var noKamar=tR.find('td').eq(0).text();
		var lantai=tR.find('td').eq(1).text();
		var kuota=tR.find('td').eq(2).text();
		var tipe=tR.find('td').eq(3).text();
		var jenis;
		if(tipe==1){
			jenis='Biasa'
		}else if(tipe==2){
			jenis='VIP'
		}
		
		var tHead = $('#listKamarAtas');
		tHead.find('th').eq(4).text("Tipe Kamar");
		tHead.find('tr').append("<th scope=col>Action</th>");
		
		tR.find('td').eq(0).empty();
		tR.find('td').eq(1).empty();
		tR.find('td').eq(2).empty();
		tR.find('td').eq(3).empty();
		tR.find('td').eq(3).removeAttr('style');
		tR.find('td').eq(0).append("<input type=number min=1 class=form-control placeholder="+noKamar+">");
		tR.find('td').eq(1).append("<input type=number min=1 class=form-control placeholder="+lantai+">");
		tR.find('td').eq(2).append("<input type=number min=1 class=form-control placeholder="+kuota+">");
		tR.find('td').eq(3).append("<select class=form-control>" +
				"<option selected value="+tipe+">"+jenis+"</option>" +
				"<option value=1>Biasa</option>" +
				"<option value=2>VIP</option>" +
				"</select>");
		
	})
	
	
	
	$(document).on('click','.update',function(){
		
		var tR = $(this).parent().parent();
		var id = $(this).attr('data-id');
		var noKamar=tR.find('input').eq(0).val();
		var lantai=tR.find('input').eq(1).val();
		var kuota=tR.find('input').eq(2).val();
		var tipe=tR.find('select').val();
		var cekNoKamar=tR.find('input').eq(0).attr('placeholder');
		var kamar={
				id:id,
				noKamar:noKamar,
				lantai:lantai,
				kuota:kuota,
				tipe:tipe
		}
		
		var async = $.ajax({
			url:'kamar/checkNo/'+noKamar,
			type:'get',
			data:JSON.stringify(noKamar),
			contentType:'application/json',
			success:function(){
				
			},
			error:function(){
				alert('mohon masukkan nomor kamar')
			}
		})
		if(lantai==""){
			alert('mohon masukkan lantai kamar')
		}
		if(kuota==""){
			alert('mohon masukkan kuota kamar')
		}
		if(lantai!="" && kuota!="" && noKamar==cekNoKamar){
			$.ajax({
				url:'kamar/update',
				type:'post',
				data:JSON.stringify(kamar),
				contentType:'application/json',
				success:function(){
					window.location="kamar"
				},
				error:function(){
					alert('gagal update')
				}
			})
		}
		else if(lantai!="" && kuota!=""){
			$.when(async).done(function(result){
				if(result==true){
					alert('nomor kamar sudah ada, mohon pilih nomor kamar yang lain')
				}
				else{
					$.ajax({
						url:'kamar/update',
						type:'post',
						data:JSON.stringify(kamar),
						contentType:'application/json',
						success:function(){
							window.location="kamar"
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
		var noKamar=tR.find('input').eq(0).attr('placeholder');
		var lantai=tR.find('input').eq(1).attr('placeholder');
		var kuota=tR.find('input').eq(2).attr('placeholder');
		var tipe=tR.find('select').val();
		var tHead = $('#listKamarAtas');
		tHead.find('th').eq(4).text("Action");
		tHead.find('th').eq(5).remove();
		
		
		tR.find('td').eq(0).empty();
		tR.find('td').eq(1).empty();
		tR.find('td').eq(2).empty();
		tR.find('td').eq(3).empty();
		tR.find('td').eq(0).append(noKamar);
		tR.find('td').eq(1).append(lantai);
		tR.find('td').eq(2).append(kuota);
		tR.find('td').eq(3).append(tipe);
		tR.find('td').eq(3).attr('style','display:none;');
	})
	
	$(document).on('click','.del',function(){
		var tR = $(this).parent().parent();
		var id = $(this).attr('data-id');
		var noKamar=tR.find('td').eq(0).text();
		var lantai=tR.find('td').eq(1).text();
		var kuota=tR.find('td').eq(2).text();
		var tipe=tR.find('td').eq(3).text();
		
		var kamar={
				id:id,
				noKamar:noKamar,
				lantai:lantai,
				kuota:kuota,
				tipe:tipe
		}
		
		$.ajax({
			url:'kamar/delete',
			type:'post',
			data:JSON.stringify(kamar),
			contentType:'application/json',
			success:function(){
				window.location="kamar"
			},
			error:function(){
				alert('kamar ini dirujuk dalam detil kamar sehingga tidak dapat di delete')
			}
		})
	})
	
})