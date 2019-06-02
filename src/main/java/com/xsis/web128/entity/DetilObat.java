package com.xsis.web128.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DetilObat {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Obat obat;
	
	private int quantity;
	
	@ManyToOne
	private CheckUp checkup;

	private int quantityObatDiBayar;
	
	@ManyToOne
	private Pembayaran pembayaran;
	
	private String statusBayar;

	public int getQuantityObatDiBayar() {
		return quantityObatDiBayar;
	}

	public void setQuantityObatDiBayar(int quantityObatDiBayar) {
		this.quantityObatDiBayar = quantityObatDiBayar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Obat getObat() {
		return obat;
	}

	public void setObat(Obat obat) {
		this.obat = obat;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CheckUp getCheckup() {
		return checkup;
	}

	public void setCheckup(CheckUp checkup) {
		this.checkup = checkup;
	}

	public Pembayaran getPembayaran() {
		return pembayaran;
	}

	public void setPembayaran(Pembayaran pembayaran) {
		this.pembayaran = pembayaran;
	}

	public String getStatusBayar() {
		return statusBayar;
	}

	public void setStatusBayar(String statusBayar) {
		this.statusBayar = statusBayar;
	}
	
	
}
