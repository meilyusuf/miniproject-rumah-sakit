package com.xsis.web128.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.fabric.xmlrpc.base.Data;
import com.xsis.web128.entity.Pasien;

@Component
public class PasienDaoImpl implements PasienDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//dao save data
	public void save(Pasien pasien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(pasien);
		session.flush();
	}
	
	//dao tampil data
	public List<Pasien> getAllPasien() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Pasien";
		List<Pasien> listPasien = session.createQuery(hql).list();
		if (listPasien.isEmpty()) {
			return null;
		}
		return listPasien;
	}
	
	public void delete(Pasien pasien) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(pasien);
		session.flush();
	}
	public Pasien getPasienById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Pasien pasien = session.get(Pasien.class, id);
		return pasien;
	}

	public void update(Pasien pasien) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	session.update(pasien);
	session.flush();
	}

	public Pasien getPasienByKode(String kodePasien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Pasien p where p.kodePasien = :searchKode";
		List pasien = session.createQuery(hql).setParameter("searchKode", kodePasien).list();
		if (pasien.isEmpty()) {
			return null;
		}
		return (Pasien) pasien.get(0);
		
	}

	

	

	

	



}
