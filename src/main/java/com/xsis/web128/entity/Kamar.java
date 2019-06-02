package com.xsis.web128.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Kamar {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int tipe;
	private int lantai;
	private int noKamar;
	private int kuota;
	private int harga;
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
	public int getKuota() {
		return kuota;
	}
	public void setKuota(int kuota) {
		this.kuota = kuota;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipe() {
		return tipe;
	}
	public void setTipe(int tipe) {
		this.tipe = tipe;
	}
	public int getLantai() {
		return lantai;
	}
	public void setLantai(int lantai) {
		this.lantai = lantai;
	}
	public int getNoKamar() {
		return noKamar;
	}
	public void setNoKamar(int noKamar) {
		this.noKamar = noKamar;
	}
	
	
}
