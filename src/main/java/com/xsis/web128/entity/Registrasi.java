package com.xsis.web128.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Registrasi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	@Temporal(TemporalType.DATE)
	private java.util.Date date;
	private String kodeRegist;
	@ManyToOne
	private Pasien pasien;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="registrasi")
	private List<DetailRegistrasi> detailRegist;
	
	public List<DetailRegistrasi> getDetailRegist() {
		return detailRegist;
	}
	public void setDetailRegist(List<DetailRegistrasi> detailRegist) {
		this.detailRegist = detailRegist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public Pasien getPasien() {
		return pasien;
	}
	public void setPasien(Pasien pasien) {
		this.pasien = pasien;
	}
	public String getKodeRegist() {
		return kodeRegist;
	}
	public void setKodeRegist(String kodeRegist) {
		this.kodeRegist = kodeRegist;
	}
	
	
}
