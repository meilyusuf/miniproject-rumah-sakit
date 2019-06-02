package com.xsis.web128.dao;

import java.util.List;

import com.xsis.web128.entity.DataTrader;
import com.xsis.web128.entity.Pasien;


public interface PasienDao {

	

	//save
	public void save(Pasien pasien);
	//tampil data
	public List<Pasien> getAllPasien();
	
	public List<DataTrader> getAllTrader();
	//delete
	public void delete(Pasien pasien);
	//tampil data by id
	public Pasien getPasienById(int id);
	
	public void update(Pasien pasien);
	public Pasien getPasienByKode(String kodePasien);
	
	public void save1(DataTrader trader);
	public DataTrader getTraderByID(String traderId);

	
	
	

	
	
	
	//update
	//delete
	//read
	
	
}
