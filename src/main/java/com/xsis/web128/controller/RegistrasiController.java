package com.xsis.web128.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.web128.entity.DetailRegistrasi;
import com.xsis.web128.entity.Dokter;
import com.xsis.web128.entity.JadwalPraktek;
import com.xsis.web128.entity.Pasien;
import com.xsis.web128.entity.Registrasi;
import com.xsis.web128.service.DokterService;
import com.xsis.web128.service.JadwalService;
import com.xsis.web128.service.PasienService;
import com.xsis.web128.service.RegistrasiService;

@Controller
@RequestMapping("/registrasi")
public class RegistrasiController {
	
	@Autowired
	RegistrasiService registrasiService;
	@Autowired
	DokterService dokterService;
	@Autowired
	JadwalService jadwalService;
	@Autowired
	PasienService pasienService;
	
	@RequestMapping
	public String index(Model model) {
		List<Dokter> listDokter = dokterService.getAllDokter();
		List<JadwalPraktek> listJadwal = jadwalService.getAllJadwal();
		model.addAttribute("listJadwal", listJadwal);
		model.addAttribute("listDokter", listDokter);
		return "registrasi";
	}

	@RequestMapping(value ="/getpasien/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Pasien getPasienById(@PathVariable int id) {
		Pasien pasien = registrasiService.getPasienById(id);
		return pasien;
	}
	
	@RequestMapping(value ="/getjadwal/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public JadwalPraktek getJadwalPraktekById(@PathVariable int id) {
		JadwalPraktek jadwalPraktek = registrasiService.getJadwalPraktekById(id);	
		return jadwalPraktek;
	}
	
	@RequestMapping(value="/saveregistrasi", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Registrasi saveRegistrasi(@RequestBody Registrasi registrasi) {
		registrasiService.saveRegist(registrasi);
		return registrasi;
	}
	@RequestMapping(value="/getKodePasien", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Pasien searchByName(@RequestBody Pasien pasien) {
		String searchKode = pasien.getKodePasien();
		Pasien pasien1 = pasienService.getPasienByKode(searchKode);
	/*	Model model = (Model) pasien1;
		model.addAttribute("pasien1", pasien1);*/
		System.out.println(pasien1.getId());
		System.out.println(pasien1.getName());
		return pasien1;
	}
/*	
	@RequestMapping(value="/getKodeReg", method=RequestMethod.POST)
	@ResponseBody
	public DetailRegistrasi getKodeReg(@RequestBody DetailRegistrasi detailRegist) {
		
		
	}*/
	

}
