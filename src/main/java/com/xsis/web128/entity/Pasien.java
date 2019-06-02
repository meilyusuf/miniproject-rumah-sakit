package com.xsis.web128.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Pasien {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String umur;
	private String alamat;
	private String email;
	private String kodePasien;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="pasien")
	private List<Registrasi> registrasi;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKodePasien() {
		return kodePasien;
	}
	public void setKodePasien(String kodePasien) {
		this.kodePasien = kodePasien;
	}
	public List<Registrasi> getRegistrasi() {
		return registrasi;
	}
	public void setRegistrasi(List<Registrasi> registrasi) {
		this.registrasi = registrasi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUmur() {
		return umur;
	}
	public void setUmur(String umur) {
		this.umur = umur;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

}
