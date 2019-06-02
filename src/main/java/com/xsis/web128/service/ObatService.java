package com.xsis.web128.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.web128.dao.ObatDao;
import com.xsis.web128.entity.Obat;

@Service
@Transactional
public class ObatService {

	@Autowired
	ObatDao obatDao;
	
	public List<Obat> getAllObat() {
		// TODO Auto-generated method stub
		return obatDao.getAllObat();
	}

	public void save(Obat obat) {
		// TODO Auto-generated method stub
		List listNamaObat = obatDao.getObatByName(obat.getNama());
		if(listNamaObat.size()!=0) {
			throw new RuntimeException("Gagal! Obat yang dimasukkan sudah terdaftar");
		}
		obatDao.save(obat);
	}

	public boolean getObatByName(String name) {
		// TODO Auto-generated method stub
		List listNamaObat = obatDao.getObatByName(name);
		if(listNamaObat.size()!=0) {
			return true;
		}
		return false;
	}

	public void update(Obat obat) {
		// TODO Auto-generated method stub
		obatDao.update(obat);
	}

	public void delete(Obat obat) {
		// TODO Auto-generated method stub
		obatDao.delete(obat);
	}

}
