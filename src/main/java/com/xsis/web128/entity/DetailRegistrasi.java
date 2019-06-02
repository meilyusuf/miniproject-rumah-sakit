package com.xsis.web128.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class DetailRegistrasi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Registrasi registrasi;
	@ManyToOne
	private JadwalPraktek jadwalPraktek;
	
	
	public JadwalPraktek getJadwalPraktek() {
		return jadwalPraktek;
	}
	public void setJadwalPraktek(JadwalPraktek jadwalPraktek) {
		this.jadwalPraktek = jadwalPraktek;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Registrasi getRegistrasi() {
		return registrasi;
	}
	public void setRegistrasi(Registrasi registrasi) {
		this.registrasi = registrasi;
	}

	
	
}
