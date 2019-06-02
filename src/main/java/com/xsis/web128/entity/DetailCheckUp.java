package com.xsis.web128.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DetailCheckUp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	private PembayaranAdm pembayaranAdm;
	private String statusbayar;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PembayaranAdm getPembayaranAdm() {
		return pembayaranAdm;
	}
	public void setPembayaranAdm(PembayaranAdm pembayaranAdm) {
		this.pembayaranAdm = pembayaranAdm;
	}
	public String getStatusbayar() {
		return statusbayar;
	}
	public void setStatusbayar(String statusbayar) {
		this.statusbayar = statusbayar;
	}
	
	


}
