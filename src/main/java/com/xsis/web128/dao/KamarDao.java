package com.xsis.web128.dao;

import java.util.List;

import com.xsis.web128.entity.Kamar;

public interface KamarDao {

	List<Kamar> getAllKamar();

	Kamar getKamarById(int id);

	List<Kamar> getKamarByTipe(int id);

	void update(Kamar kamar);

	void save(Kamar kamar);

	List getKamarByNomor(int noKamar);

	void delete(Kamar kamar);

}
