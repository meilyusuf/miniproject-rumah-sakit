package com.xsis.web128.dao;

import java.util.List;

import com.xsis.web128.entity.Obat;

public interface ObatDao {

	List<Obat> getAllObat();

	Obat getObatById(int id);

	void update(Obat obat);

	void save(Obat obat);

	List getObatByName(String name);

	void delete(Obat obat);

}
