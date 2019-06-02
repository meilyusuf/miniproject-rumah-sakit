package com.xsis.web128.dao;

import java.util.List;

import com.xsis.web128.entity.CheckUp;
import com.xsis.web128.entity.DetailCheckUp;
import com.xsis.web128.entity.DetilKamar;
import com.xsis.web128.entity.DetilObat;
import com.xsis.web128.entity.Pasien;

public interface CheckupDao {

	Pasien getPasienByRegis(int id);

	void save(CheckUp checkup);

	void saveDetilKamar(DetilKamar detilKamar);

	void saveResep(DetilObat detilObat);

	List<CheckUp> getCheckUpByRegis(int id);

	void saveDetailCheckup(List<DetailCheckUp> detailcheckup);

}
