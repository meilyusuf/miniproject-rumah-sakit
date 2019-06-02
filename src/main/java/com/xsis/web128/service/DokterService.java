package com.xsis.web128.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.web128.dao.DokterDao;
import com.xsis.web128.dao.JadwalDao;
import com.xsis.web128.entity.Dokter;
import com.xsis.web128.entity.JadwalPraktek;

@Service
@Transactional
public class DokterService {
	
	@Autowired
	DokterDao dokterDao;
	@Autowired
	JadwalDao jadwalDao;

	public List<Dokter> getAllDokter() {
		// TODO Auto-generated method stub
		List<Dokter> listDokter = dokterDao.getAllDokter();
		for (Dokter dokter: listDokter) {
			List<JadwalPraktek> listJadwal = jadwalDao.getJadwalPraktekByDokter(dokter);
			dokter.setJadwalPraktek(listJadwal);
		}
		return listDokter;
	}

}
