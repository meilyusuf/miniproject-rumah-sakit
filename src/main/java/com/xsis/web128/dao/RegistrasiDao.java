package com.xsis.web128.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xsis.web128.entity.DetailRegistrasi;
import com.xsis.web128.entity.Dokter;
import com.xsis.web128.entity.JadwalPraktek;
import com.xsis.web128.entity.Pasien;
import com.xsis.web128.entity.Registrasi;


public interface RegistrasiDao {

	public List<Pasien> getAllPasien();

	public Pasien getPasienByid(int id);

	public List<Dokter> getAllDokter();

	public JadwalPraktek getJadwalPraktekById(int id);

	public void saveRegist(Registrasi registrasi);

	public void saveDetailRegistrasi(List<DetailRegistrasi> detailregist);

	public List<Registrasi> getAllRegist();

	public List<DetailRegistrasi> getAllDetailRegist();

	public List<DetailRegistrasi> getDetailRegistByRegist(Registrasi registrasi);

	public Pasien getPasienByRegis(int id);

	public List<Registrasi> getRegistrasiByPasien(Pasien pasien);

	

}
