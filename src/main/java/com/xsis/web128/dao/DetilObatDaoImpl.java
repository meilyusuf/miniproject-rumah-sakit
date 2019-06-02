package com.xsis.web128.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.web128.entity.CheckUp;
import com.xsis.web128.entity.DetilObat;

@Repository
public class DetilObatDaoImpl implements DetilObatDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void updatePembayaran(DetilObat detilObat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(detilObat);
		session.flush();
	}

	public List<DetilObat> getDetilObatByRegis(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from CheckUp r where r.registrasi.id="+id;
		List<CheckUp> listCheckUp = session.createQuery(hql).list();
		List<DetilObat> listDetilObat = new ArrayList();
		for(int i=0;i<listCheckUp.size();i++) {
			hql="from DetilObat d where d.checkup.id="+listCheckUp.get(i).getId()+" and statusBayar is null";
			listDetilObat.addAll(session.createQuery(hql).list());
		}
		return listDetilObat;
	}

	public void save(DetilObat detilObat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(detilObat);
		session.flush();
	}

}
