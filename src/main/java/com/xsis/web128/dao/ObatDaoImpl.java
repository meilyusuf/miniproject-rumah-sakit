package com.xsis.web128.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.web128.entity.Obat;

@Repository
public class ObatDaoImpl implements ObatDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Obat> getAllObat() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Obat.class).list();
	}

	public Obat getObatById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Obat.class, id);
	}

	public void update(Obat obat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(obat);
		session.flush();
	}

	public void save(Obat obat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(obat);
		session.flush();
	}

	public List getObatByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "select nama from Obat o where o.nama='"+name+"'";
		List listNamaObat = session.createQuery(hql).list();
		return listNamaObat;
	}

	public void delete(Obat obat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(obat);
		session.flush();
	}


}
