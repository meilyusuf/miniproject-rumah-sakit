package com.xsis.web128.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.web128.dao.CheckupDao;
import com.xsis.web128.dao.DetilKamarDao;
import com.xsis.web128.dao.DetilObatDao;
import com.xsis.web128.dao.KamarDao;
import com.xsis.web128.dao.ObatDao;
import com.xsis.web128.dao.RegistrasiDao;
import com.xsis.web128.entity.CheckUp;
import com.xsis.web128.entity.DetilKamar;
import com.xsis.web128.entity.DetilObat;
import com.xsis.web128.entity.Kamar;
import com.xsis.web128.entity.Pasien;

@Service
@Transactional
public class CheckupService {

	@Autowired
	CheckupDao checkupDao;
	
	@Autowired
	KamarDao kamarDao;
	
	@Autowired
	DetilObatDao detilObatDao;
	
	@Autowired
	DetilKamarDao detilKamarDao;
	
	@Autowired
	RegistrasiDao registrasiDao;
	
	public Pasien getPasienByRegis(int id) {
		// TODO Auto-generated method stub
		return registrasiDao.getPasienByRegis(id);
	}

	public void save(CheckUp checkup) {
		// TODO Auto-generated method stub
		checkupDao.save(checkup);
		
		if(checkup.getListDetilKamar()!=null) {
			DetilKamar detilKamar = checkup.getListDetilKamar().get(0);
			detilKamar.setCheckup(checkup);
			detilKamarDao.save(detilKamar);
			
			Kamar kamar = kamarDao.getKamarById(detilKamar.getKamar().getId());
			int kuota = kamar.getKuota();
			kuota--;
			kamar.setKuota(kuota);
			kamarDao.update(kamar);
			
		}
		
		List<DetilObat> listDetilObat = checkup.getListDetilObat();
		for(DetilObat detilObat: listDetilObat) {
			detilObat.setCheckup(checkup);
			detilObatDao.save(detilObat);
		}
	}

	public void saveDetilKamar(DetilKamar detilKamar) {
		// TODO Auto-generated method stub
		checkupDao.saveDetilKamar(detilKamar);
	}

	public void saveResep(DetilObat detilObat) {
		// TODO Auto-generated method stub
		checkupDao.saveResep(detilObat);
	}

	public List<Kamar> getKamarByTipe(int id) {
		// TODO Auto-generated method stub
		return kamarDao.getKamarByTipe(id);
	}

	public Kamar cekDetilKamarByRegis(int id) {
		// TODO Auto-generated method stub
		List<CheckUp> listCheckUp = checkupDao.getCheckUpByRegis(id);
		Kamar kamar = new Kamar();
		
		if(listCheckUp.isEmpty()) {
			return kamar;
		}
		
		for(CheckUp checkUp:listCheckUp) {
			System.out.println(checkUp.getId());
			System.out.println(checkUp.getListDetilKamar());
			if(checkUp.getListDetilKamar().isEmpty()==false) {
				kamar=checkUp.getListDetilKamar().get(0).getKamar();
				break;
			}
		}
		
		return kamar;
	}

}
