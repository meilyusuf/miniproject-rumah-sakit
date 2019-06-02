package com.xsis.web128.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.web128.entity.DetailCheckUp;

@Repository
public class CheckupDaoDetailImpl implements CheckupDaoDetail{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(DetailCheckUp det) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(det);
		session.flush();
	}
	
	
}
