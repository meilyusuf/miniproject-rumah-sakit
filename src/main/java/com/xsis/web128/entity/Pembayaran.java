package com.xsis.web128.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pembayaran {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	private int hargaTotal;
	@Column
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="pembayaran")
	private List<DetilObat> listDetilObat;
	
	public int getId() {
		return id;
	}
	public List<DetilObat> getListDetilObat() {
		return listDetilObat;
	}
	public void setListDetilObat(List<DetilObat> listDetilObat) {
		this.listDetilObat = listDetilObat;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHargaTotal() {
		return hargaTotal;
	}
	public void setHargaTotal(int hargaTotal) {
		this.hargaTotal = hargaTotal;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
