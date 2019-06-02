package com.xsis.web128.dao;

import java.util.List;

import com.xsis.web128.entity.DataTrader;
import com.xsis.web128.entity.Dokter;
import com.xsis.web128.entity.JadwalPraktek;
import com.xsis.web128.entity.Transaksi;


public interface JadwalDao {
	
	public List<JadwalPraktek> getJadwalPraktekByDokter(Dokter dokter);

	public List<JadwalPraktek> getAllJadwal();

	public JadwalPraktek getJadwalById(int id);

	public void save(JadwalPraktek jadwalPraktek);

	public void update(JadwalPraktek jadwalPraktek);

	public void delete(JadwalPraktek jadwalPraktek);

	public List<Transaksi> findByIDTrader(String traderId);

	
}
