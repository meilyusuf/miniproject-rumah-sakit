package com.xsis.web128.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.web128.dao.CheckupDao;
import com.xsis.web128.dao.CheckupDaoDetail;
import com.xsis.web128.dao.PembayaranAdmDao;
import com.xsis.web128.entity.CheckUp;
import com.xsis.web128.entity.DetailCheckUp;
import com.xsis.web128.entity.DetailRegistrasi;
import com.xsis.web128.entity.PembayaranAdm;

@Service
@Transactional
public class PembayaranAdmService {
	
	@Autowired
	CheckupDao checkupDao;
	@Autowired
	PembayaranAdmDao pembayaranAdmDao;
	@Autowired
	CheckupDaoDetail checkupDetailDao;
	

	public List<CheckUp> getCheckUpByRegis(int id) {
		// TODO Auto-generated method stub
		return checkupDao.getCheckUpByRegis(id);
	}

	public void savePembayaranAdm(PembayaranAdm pembayaranAdm) {
		// TODO Auto-generated method stub
		pembayaranAdmDao.savePembayaranAdm(pembayaranAdm);
		for(DetailCheckUp det : pembayaranAdm.getDetailcheckup()) {
			det.setPembayaranAdm(pembayaranAdm);
			det.setStatusbayar("bayar");
			checkupDetailDao.save(det);
		}
		
	}
	public void saveDetailCheckup(List<DetailCheckUp> detailcheckup) {
		// TODO Auto-generated method stub
		checkupDao.saveDetailCheckup(detailcheckup);
	}

	
	

}
