package com.xsis.web128.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.web128.entity.CheckUp;
import com.xsis.web128.entity.DetilObat;
import com.xsis.web128.entity.Pasien;
import com.xsis.web128.entity.PembayaranAdm;
import com.xsis.web128.entity.Registrasi;
import com.xsis.web128.service.PasienService;
import com.xsis.web128.service.PembayaranAdmService;
import com.xsis.web128.service.PembayaranService;
import com.xsis.web128.service.RegistrasiService;

@Controller
@RequestMapping("/pembayaranAdm")
public class PembayaranAdmController {
	
	@Autowired
	PembayaranService pembayaranService;
	@Autowired
	PembayaranAdmService pembayaranAdmService;
	@Autowired
	RegistrasiService registrasiService;
	@Autowired
	PasienService pasienService;
	
	@RequestMapping
	public String index(Model model) {
		List<Registrasi> listRegist = registrasiService.getAllRegist();
		List<Pasien> listPasien = pasienService.getAllPasien();
		model.addAttribute("listRegist",listRegist);
		model.addAttribute("listPasien",listPasien);
		return "pembayaranAdm";
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Pasien getPasienByRegis(@PathVariable int id) {
		Pasien listPasien = pembayaranService.getPasienByRegis(id);
		return listPasien;	
	}
	
	@RequestMapping(value="getCheckUp/{id}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<CheckUp> getCheckUpByRegis(@PathVariable int id) {
		List<CheckUp> listCheckUp = pembayaranAdmService.getCheckUpByRegis(id);
		System.out.println(listCheckUp);
		return listCheckUp;
	}
	@RequestMapping(value="savePembayaranAdm",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void savePembayaranAdm(@RequestBody PembayaranAdm pembayaranAdm) {
		pembayaranAdmService.savePembayaranAdm(pembayaranAdm);
	}
}
