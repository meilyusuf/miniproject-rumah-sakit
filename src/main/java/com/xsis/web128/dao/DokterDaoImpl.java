package com.xsis.web128.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.web128.entity.Dokter;

@Repository
public class DokterDaoImpl implements DokterDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Dokter> getAllDokter() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Dokter> listDokter = session.createCriteria(Dokter.class).list();
		return listDokter;
	}

}
