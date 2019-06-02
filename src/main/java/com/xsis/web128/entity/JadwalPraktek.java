package com.xsis.web128.entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class JadwalPraktek {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String hari;
	private String jamPraktek;
	@ManyToOne
	private Dokter dokter;
	
	public Dokter getDokter() {
		return dokter;
	}
	public void setDokter(Dokter dokter) {
		this.dokter = dokter;
	}
	/*@OneToMany(fetch=FetchType.LAZY, mappedBy="dokter")
	private List<JadwalPraktek> jadwalPraktek;*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHari() {
		return hari;
	}
	public void setHari(String hari) {
		this.hari = hari;
	}
	public String getJamPraktek() {
		return jamPraktek;
	}
	public void setJamPraktek(String jamPraktek) {
		this.jamPraktek = jamPraktek;
	}
/*	public List<Dokter> getDokter() {
		return dokter;
	}
	public void setDokter(List<Dokter> dokter) {
		this.dokter = dokter;
	}*/



	

	

}
