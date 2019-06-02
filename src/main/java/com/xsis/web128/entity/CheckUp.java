package com.xsis.web128.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="checkup_seq")
public class CheckUp {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	@ManyToOne
	private Dokter dokter;
	@ManyToOne//(cascade=CascadeType.ALL)
	private Registrasi registrasi;
	

	private String namaPenyakit;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date tanggalCheckUp;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="checkup")
	private List<DetilObat> listDetilObat;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="checkup")
	private List<DetilKamar> listDetilKamar;
	
	public List<DetilKamar> getListDetilKamar() {
		return listDetilKamar;
	}

	public void setListDetilKamar(List<DetilKamar> listDetilKamar) {
		this.listDetilKamar = listDetilKamar;
	}

	public List<DetilObat> getListDetilObat() {
		return listDetilObat;
	}

	public void setListDetilObat(List<DetilObat> listDetilObat) {
		this.listDetilObat = listDetilObat;
	}

	public Dokter getDokter() {
		return dokter;
	}

	public void setDokter(Dokter dokter) {
		this.dokter = dokter;
	}

	public Registrasi getRegistrasi() {
		return registrasi;
	}

	public void setRegistrasi(Registrasi registrasi) {
		this.registrasi = registrasi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamaPenyakit() {
		return namaPenyakit;
	}

	public void setNamaPenyakit(String namaPenyakit) {
		this.namaPenyakit = namaPenyakit;
	}

	public Date getTanggalCheckUp() {
		return tanggalCheckUp;
	}

	public void setTanggalCheckUp(Date tanggalCheckUp) {
		this.tanggalCheckUp = tanggalCheckUp;
	}
	
	
}
