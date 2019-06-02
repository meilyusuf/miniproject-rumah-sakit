package com.xsis.web128.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.web128.entity.DetailCheckUp;
import com.xsis.web128.entity.PembayaranAdm;

@Repository
public class PembayaranDaoAdmImpl implements PembayaranAdmDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void savePembayaranAdm(PembayaranAdm pembayaranAdm) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(pembayaranAdm);
		session.flush();
	}

	public void savePembayaranAdm(List<DetailCheckUp> detailcheckup) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(detailcheckup);
		session.flush();
	}
	
	
	
}
