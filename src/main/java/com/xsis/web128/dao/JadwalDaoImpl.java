package com.xsis.web128.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.xsis.web128.entity.Dokter;
import com.xsis.web128.entity.JadwalPraktek;



@Repository
public class JadwalDaoImpl implements JadwalDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<JadwalPraktek> getAllJadwal() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<JadwalPraktek> listJadwal = session.createCriteria(JadwalPraktek.class).list();
		return listJadwal;
	}

	public List<JadwalPraktek> getJadwalPraktekByDokter(Dokter dokter) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from JadwalPraktek j where j.dokter.id = :dokter";
		List<JadwalPraktek> listJadwal = session.createQuery(hql).setParameter("dokter", dokter.getId()).list();
		if (listJadwal.isEmpty())
		return null;
		else
			return listJadwal;
	}

	public JadwalPraktek getJadwalById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		JadwalPraktek jadwalPraktek = session.get(JadwalPraktek.class, id);
		return jadwalPraktek;
	}

	public void save(JadwalPraktek jadwalPraktek) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(jadwalPraktek);
		session.flush();
	}

	public void update(JadwalPraktek jadwalPraktek) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(jadwalPraktek);
		session.flush();
	}

	public void delete(JadwalPraktek jadwalPraktek) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(jadwalPraktek);
		session.flush();
	}



	

	

}
