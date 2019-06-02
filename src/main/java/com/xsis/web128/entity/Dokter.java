package com.xsis.web128.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Dokter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String spesialis;
	private int biaya;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="dokter")
	@JsonIgnoreProperties(allowSetters = true, value = {"dokter"})
	private List<JadwalPraktek> jadwalPraktek;
	
	public int getBiaya() {
		return biaya;
	}
	public void setBiaya(int biaya) {
		this.biaya = biaya;
	}
	public List<JadwalPraktek> getJadwalPraktek() {
		return jadwalPraktek;
	}
	public void setJadwalPraktek(List<JadwalPraktek> jadwalPraktek) {
		this.jadwalPraktek = jadwalPraktek;
	}
	public void setSpesialis(String spesialis) {
		this.spesialis = spesialis;
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
	public String getSpesialis() {
		return spesialis;
	}

	
	
	
	
}
