package com.xsis.web128.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.web128.entity.DetilKamar;

@Repository
public class DetilKamarDaoImpl implements DetilKamarDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(DetilKamar detilKamar) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(detilKamar);
		session.flush();
	}

	
}
