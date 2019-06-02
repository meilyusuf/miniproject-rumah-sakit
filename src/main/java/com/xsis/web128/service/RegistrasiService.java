package com.xsis.web128.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xsis.web128.dao.RegistrasiDao;
import com.xsis.web128.dao.RegistrasiDaoDetail;
import com.xsis.web128.entity.DetailRegistrasi;
import com.xsis.web128.entity.Dokter;
import com.xsis.web128.entity.JadwalPraktek;
import com.xsis.web128.entity.Pasien;
import com.xsis.web128.entity.Registrasi;

@Service
@Transactional
public class RegistrasiService {
	
	@Autowired
	private RegistrasiDao registrasiDao;
	@Autowired
	private RegistrasiDaoDetail registrasiDaoDetail;
	
	public List<Pasien> getAllPasien() {
		// TODO Auto-generated method stub
		return registrasiDao.getAllPasien();
	}
	public Pasien getPasienById(int id) {
		// TODO Auto-generated method stub
		return registrasiDao.getPasienByid(id);
	}
	
	public List<Dokter> getAllDokter() {
		// TODO Auto-generated method stub
		return registrasiDao.getAllDokter();
	}

	public JadwalPraktek getJadwalPraktekById(int id) {
		// TODO Auto-generated method stub
		return registrasiDao.getJadwalPraktekById(id);
	}

	public void saveRegist(Registrasi registrasi) {
		 registrasiDao.saveRegist(registrasi);
		 for (DetailRegistrasi det : registrasi.getDetailRegist()) {
			 det.setRegistrasi(registrasi);
			 registrasiDaoDetail.save(det);
		 }	 
	}
	public void saveDetailRegistrasi(List<DetailRegistrasi> detailregist) {
		// TODO Auto-generated method stub
		registrasiDao.saveDetailRegistrasi(detailregist);
	}
	public List<Registrasi> getAllRegist() {
		// TODO Auto-generated method stub
		List<Registrasi> listRegist = registrasiDao.getAllRegist();
		for(Registrasi registrasi : listRegist) {
			List<DetailRegistrasi> listDetailRegist = registrasiDao.getDetailRegistByRegist(registrasi);
		}
		return listRegist;
	}
	public List<DetailRegistrasi> getAllDetailRegist() {
		// TODO Auto-generated method stub
		return registrasiDao.getAllDetailRegist();
	}
	
}
