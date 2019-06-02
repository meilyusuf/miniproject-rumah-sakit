package com.xsis.web128.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.web128.entity.Kamar;

@Repository
public class KamarDaoImpl implements KamarDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Kamar> getAllKamar() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Kamar.class).list();
	}

	public Kamar getKamarById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Kamar.class, id);
	}

	public List<Kamar> getKamarByTipe(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql="from Kamar k where k.tipe="+id+" and k.kuota!=0";
		return session.createQuery(hql).list();
	}

	public void update(Kamar kamar) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(kamar);
		session.flush();
	}

	public void save(Kamar kamar) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(kamar);
		session.flush();
	}

	public List getKamarByNomor(int noKamar) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "select noKamar from Kamar k where k.noKamar="+noKamar;
		List listNamaObat = session.createQuery(hql).list();
		return listNamaObat;
	}

	public void delete(Kamar kamar) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(kamar);
		session.flush();
	}

}
