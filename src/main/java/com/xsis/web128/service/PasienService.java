package com.xsis.web128.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.xsis.web128.dao.PasienDao;
import com.xsis.web128.dao.RegistrasiDao;
import com.xsis.web128.entity.Pasien;

@Transactional
@Component
public class PasienService {

	@Autowired
	PasienDao pasienDao;
	@Autowired
	RegistrasiDao registrasiDao;
	

	
	public void save(Pasien pasien) {
		pasienDao.save(pasien);
	}
	
	
	

	public  List<Pasien> getAllPasien() {
		return pasienDao.getAllPasien();
	}

	public void delete(Pasien pasien) {
		
		pasienDao.delete(pasien);
	}


	public Pasien getPasienById(int id) {
		
		return pasienDao.getPasienById(id);
	}

	public void update(Pasien pasien) {
		
		 pasienDao.update(pasien);
	}

	public Pasien getPasienByKode(String kodePasien) {
		
		return pasienDao.getPasienByKode(kodePasien);
	}

	

	
}
