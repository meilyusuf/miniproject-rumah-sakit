package com.xsis.web128.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.web128.dao.JadwalDao;
import com.xsis.web128.entity.DataTrader;
import com.xsis.web128.entity.Dokter;
import com.xsis.web128.entity.JadwalPraktek;
import com.xsis.web128.entity.Transaksi;

@Service
@Transactional
public class JadwalService {
	
	@Autowired
	private JadwalDao jadwalDao;
	
	public List<JadwalPraktek> getAllJadwal() {
		// TODO Auto-generated method stub
		return jadwalDao.getAllJadwal();
	}

	public JadwalPraktek getJadwalPraktekById(int id) {
		// TODO Auto-generated method stub
		return jadwalDao.getJadwalById(id);
	}

	public void save(JadwalPraktek jadwalPraktek) {
		// TODO Auto-generated method stub
		 jadwalDao.save(jadwalPraktek);
	}

	public void update(JadwalPraktek jadwalPraktek) {
		// TODO Auto-generated method stub
		jadwalDao.update(jadwalPraktek);
	}

	public void delete(JadwalPraktek jadwalPraktek) {
		// TODO Auto-generated method stub
		jadwalDao.delete(jadwalPraktek);
	}

	public List<Transaksi> findByID(String traderId) {
		// TODO Auto-generated method stub
		return jadwalDao.findByIDTrader(traderId);
		
	}

	

}
