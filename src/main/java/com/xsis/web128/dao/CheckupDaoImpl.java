package com.xsis.web128.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.web128.entity.CheckUp;
import com.xsis.web128.entity.DetailCheckUp;
import com.xsis.web128.entity.DetilKamar;
import com.xsis.web128.entity.DetilObat;
import com.xsis.web128.entity.Pasien;
import com.xsis.web128.entity.Registrasi;

@Repository
public class CheckupDaoImpl implements CheckupDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Pasien getPasienByRegis(int id) {
		// TODO Auto-generated method stub
		String hql = "from Registrasi p where p.id="+id;
		Session session = sessionFactory.getCurrentSession();
		List<Registrasi> listRegistrasi=session.createQuery(hql).list();
		int idPasien = listRegistrasi.get(0).getPasien().getId();
		return session.get(Pasien.class, idPasien);
	}

	public void save(CheckUp checkup) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(checkup);
		session.flush();
	}

	public void saveDetilKamar(DetilKamar detilKamar) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(detilKamar);
		session.flush();
	}

	public void saveResep(DetilObat detilObat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(detilObat);
		session.flush();
	}

	public List<CheckUp> getCheckUpByRegis(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql="from CheckUp c where c.registrasi.id="+id;
		List<CheckUp> listCheckUp = session.createQuery(hql).list();	
		return listCheckUp;
	}

	public void saveDetailCheckup(List<DetailCheckUp> detailcheckup) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(detailcheckup);
		session.flush();
	}

	


}
