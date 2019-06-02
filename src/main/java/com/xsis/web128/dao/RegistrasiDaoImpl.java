package com.xsis.web128.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.web128.entity.DetailRegistrasi;
import com.xsis.web128.entity.Dokter;
import com.xsis.web128.entity.JadwalPraktek;
import com.xsis.web128.entity.Pasien;
import com.xsis.web128.entity.Registrasi;

@Repository
public class RegistrasiDaoImpl implements RegistrasiDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Pasien> getAllPasien() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Pasien> listPasien = session.createCriteria(Pasien.class).list();
		return listPasien;
	}

	public Pasien getPasienByid(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Pasien.class, id);
	}

	public List<Dokter> getAllDokter() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Dokter> listDokter = session.createCriteria(Dokter.class).list(); 
		return listDokter;
	}

	public JadwalPraktek getJadwalPraktekById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(JadwalPraktek.class, id);
	}

	public void saveRegist(Registrasi registrasi) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(registrasi);
		session.flush();
	}

	public void saveDetailRegistrasi(DetailRegistrasi detailregist) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(detailregist);
		session.flush();
	}

	public void saveDetailRegistrasi(List<DetailRegistrasi> detailregist) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(detailregist);
		session.flush();
	}

	public List<Registrasi> getAllRegist() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Registrasi> listRegist = session.createCriteria(Registrasi.class).list();
		return listRegist;
	}

	public List<DetailRegistrasi> getAllDetailRegist() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<DetailRegistrasi> listDetailRegist = session.createCriteria(DetailRegistrasi.class).list();
		return listDetailRegist;
	}


	public List<DetailRegistrasi> getDetailRegistByRegist(Registrasi registrasi) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from DetailRegistrasi det where det.registrasi.id = :registrasi";
		List<DetailRegistrasi> listDetailRegist = session.createQuery(hql).setParameter("registrasi", registrasi.getId()).list();
		if (listDetailRegist.isEmpty())
		return null;
		else
			return listDetailRegist;
	}

	public Pasien getPasienByRegis(int id) {
		// TODO Auto-generated method stub
		String hql = "from Registrasi p where p.id="+id;
		Session session = sessionFactory.getCurrentSession();
		List<Registrasi> listRegistrasi=session.createQuery(hql).list();
		int idPasien = listRegistrasi.get(0).getPasien().getId();
		return session.get(Pasien.class, idPasien);
	}

	public List<Registrasi> getRegistrasiByPasien(Pasien pasien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Registrasi r where r.pasien.id = :pasien";
		List<Registrasi> listRegist = session.createQuery(hql).setParameter("pasien", pasien.getId()).list();
		if (listRegist.isEmpty())
		return null;
		else
			return listRegist;
	}



	






}
