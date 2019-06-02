package com.xsis.web128.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.web128.dao.DetilObatDao;
import com.xsis.web128.dao.ObatDao;
import com.xsis.web128.dao.PasienDao;
import com.xsis.web128.dao.PembayaranDao;
import com.xsis.web128.dao.RegistrasiDao;
import com.xsis.web128.entity.CheckUp;
import com.xsis.web128.entity.DetilObat;
import com.xsis.web128.entity.Obat;
import com.xsis.web128.entity.Pasien;
import com.xsis.web128.entity.Pembayaran;
import com.xsis.web128.entity.Registrasi;

@Service
@Transactional
public class PembayaranService {

	@Autowired
	RegistrasiDao registrasiDao;
	
	@Autowired
	PembayaranDao pembayaranDao;
	
	@Autowired
	DetilObatDao detilObatDao;
	
	@Autowired
	ObatDao obatDao;
	
	public Pasien getPasienByRegis(int id) {
		// TODO Auto-generated method stub
		return registrasiDao.getPasienByRegis(id);
	}

	public List<DetilObat> getDetilObatByRegis(int id) {
		// TODO Auto-generated method stub
		return detilObatDao.getDetilObatByRegis(id);
	}

	public void savePembayaran(Pembayaran pembayaran) {
		// TODO Auto-generated method stub
		pembayaranDao.savePembayaran(pembayaran);
		for(DetilObat detilObat: pembayaran.getListDetilObat()) {
			detilObat.setPembayaran(pembayaran);
			detilObat.setStatusBayar("bayar");
			
			detilObatDao.updatePembayaran(detilObat);
			
			Obat obat = obatDao.getObatById(detilObat.getObat().getId());
			int stok = obat.getQuantity();
			if(stok < detilObat.getQuantityObatDiBayar()) {
				throw new RuntimeException("Gagal! Pembelian melebihi stok obat yang ada");
			}
			stok-=detilObat.getQuantityObatDiBayar();
			obat.setQuantity(stok);
			obatDao.update(obat);
		}
	}



	
}
