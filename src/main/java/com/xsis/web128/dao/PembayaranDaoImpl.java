package com.xsis.web128.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.web128.entity.CheckUp;
import com.xsis.web128.entity.DetilObat;
import com.xsis.web128.entity.Obat;
import com.xsis.web128.entity.Pasien;
import com.xsis.web128.entity.Pembayaran;
import com.xsis.web128.entity.Registrasi;

@Repository
public class PembayaranDaoImpl implements PembayaranDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void savePembayaran(Pembayaran pembayaran) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(pembayaran);
		session.flush();
	}

}
