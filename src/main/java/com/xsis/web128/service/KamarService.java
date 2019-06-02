package com.xsis.web128.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.web128.dao.KamarDao;
import com.xsis.web128.entity.Kamar;

@Service
@Transactional
public class KamarService {

	@Autowired
	KamarDao kamarDao;
	
	public List<Kamar> getAllKamar() {
		// TODO Auto-generated method stub
		return kamarDao.getAllKamar();
	}

	public Kamar getKamarById(int id) {
		// TODO Auto-generated method stub
		return kamarDao.getKamarById(id);
	}

	public boolean save(Kamar kamar) {
		// TODO Auto-generated method stub
		List listNoKamar = kamarDao.getKamarByNomor(kamar.getNoKamar());
//		if(listNoKamar.size()!=0) {
//			throw new RuntimeException("Gagal! nomor kamar yang dimasukkan sudah terdaftar");
//		}
		if(listNoKamar.size()==0) {
			kamarDao.save(kamar);
		}else {
			return true;
		}
		return false;
	}

	public boolean getKamarByNomor(int noKamar) {
		// TODO Auto-generated method stub
		List listNoKamar = kamarDao.getKamarByNomor(noKamar);
		if(listNoKamar.size()!=0) {
			return true;
		}
		return false;
	}

	public void update(Kamar kamar) {
		// TODO Auto-generated method stub
		kamarDao.update(kamar);
	}

	public void delete(Kamar kamar) {
		// TODO Auto-generated method stub
		kamarDao.delete(kamar);
	}

}
