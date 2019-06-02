package com.xsis.web128.dao;

import java.util.List;

import com.xsis.web128.entity.Pasien;


public interface PasienDao {

	

	//save
	public void save(Pasien pasien);
	//tampil data
	public List<Pasien> getAllPasien();
	
	
	//delete
	public void delete(Pasien pasien);
	//tampil data by id
	public Pasien getPasienById(int id);
	
	public void update(Pasien pasien);
	public Pasien getPasienByKode(String kodePasien);
	
	

	
	
	

	
	
	
	//update
	//delete
	//read
	
	
}
