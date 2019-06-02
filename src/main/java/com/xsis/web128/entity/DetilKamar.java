package com.xsis.web128.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class DetilKamar {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	private PembayaranAdm pembayaranAdm;
	
	public PembayaranAdm getPembayaranAdm() {
		return pembayaranAdm;
	}
	public void setPembayaranAdm(PembayaranAdm pembayaranAdm) {
		this.pembayaranAdm = pembayaranAdm;
	}
	@OneToOne
	private Kamar kamar;
	
	@ManyToOne
	private CheckUp checkup;
	
	private String statusBayar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Kamar getKamar() {
		return kamar;
	}

	public void setKamar(Kamar kamar) {
		this.kamar = kamar;
	}

	public CheckUp getCheckup() {
		return checkup;
	}

	public void setCheckup(CheckUp checkup) {
		this.checkup = checkup;
	}
	public String getStatusBayar() {
		return statusBayar;
	}
	public void setStatusBayar(String statusBayar) {
		this.statusBayar = statusBayar;
	}


	
}
