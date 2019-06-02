package com.xsis.web128.dao;

import java.util.List;

import com.xsis.web128.entity.DetilObat;

public interface DetilObatDao {

	void updatePembayaran(DetilObat detilObat);

	List<DetilObat> getDetilObatByRegis(int id);

	void save(DetilObat detilObat);

}
