package com.xsis.web128.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.xsis.web128.dao.PasienDao;
import com.xsis.web128.dao.RegistrasiDao;
import com.xsis.web128.entity.DataTrader;
import com.xsis.web128.entity.Pasien;
import com.xsis.web128.entity.Registrasi;

@Transactional
@Component
public class PasienService {

	@Autowired
	PasienDao pasienDao;
	@Autowired
	RegistrasiDao registrasiDao;
	
	public List<DataTrader> getAllTrader() {
		return pasienDao.getAllTrader();
	}
	
	public void save(Pasien pasien) {
		pasienDao.save(pasien);
	}
	
	public void save1(DataTrader trader) {
		pasienDao.save1(trader);
	}
	
	

	public  List<Pasien> getAllPasien() {
		// TODO Auto-generated method stub
	/*	List<Pasien> listPasien = pasienDao.getAllPasien();
		for (Pasien pasien : listPasien) {
			List<Registrasi> listRegist = registrasiDao.getRegistrasiByPasien(pasien);
			pasien.setRegistrasi(listRegist);
		}*/
		return pasienDao.getAllPasien();
	}

	public void delete(Pasien pasien) {
		// TODO Auto-generated method stub
		//.delete sudah disediakan hibernate
		pasienDao.delete(pasien);
	}


	public Pasien getPasienById(int id) {
		// TODO Auto-generated method stub
		return pasienDao.getPasienById(id);
	}

	public void update(Pasien pasien) {
		// TODO Auto-generated method stub
		 pasienDao.update(pasien);
	}

	public Pasien getPasienByKode(String kodePasien) {
		// TODO Auto-generated method stub
		return pasienDao.getPasienByKode(kodePasien);
	}

	public DataTrader getTraderById(String traderId) {
		// TODO Auto-generated method stub
		return pasienDao.getTraderByID(traderId);
	}

	
}
