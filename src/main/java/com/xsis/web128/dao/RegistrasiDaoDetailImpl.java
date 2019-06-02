package com.xsis.web128.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsis.web128.entity.DetailRegistrasi;

@Repository
public class RegistrasiDaoDetailImpl implements RegistrasiDaoDetail {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(DetailRegistrasi det) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				session.save(det);
				session.flush();
	}

	
	
}
