package com.xsis.web128.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsis.web128.entity.Pasien;


@Repository
public interface PasienRepository extends JpaRepository<Pasien, Long> {

	
	public Pasien findById(Long id);
	
	public Pasien findByKodePasien(String kodePasien);
	
		
	
}
