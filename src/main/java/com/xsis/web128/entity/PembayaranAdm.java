package com.xsis.web128.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PembayaranAdm {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	private int hargaTotal;
	@Column
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="pembayaranAdm")
	private List<DetailCheckUp> detailcheckup;
	
	
	public List<DetailCheckUp> getDetailcheckup() {
		return detailcheckup;
	}
	public void setDetailcheckup(List<DetailCheckUp> detailcheckup) {
		this.detailcheckup = detailcheckup;
	}
	public int getId() {
		return id;
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
