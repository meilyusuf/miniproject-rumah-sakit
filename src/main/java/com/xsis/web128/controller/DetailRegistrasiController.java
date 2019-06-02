package com.xsis.web128.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.web128.entity.DetailRegistrasi;
import com.xsis.web128.entity.Registrasi;
import com.xsis.web128.service.DokterService;
import com.xsis.web128.service.JadwalService;
import com.xsis.web128.service.PasienService;
import com.xsis.web128.service.RegistrasiService;

@Controller
@RequestMapping("/detailRegist")
public class DetailRegistrasiController {
	
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
		List<Registrasi> listRegist = registrasiService.getAllRegist();
		List<DetailRegistrasi> listDetailRegist = registrasiService.getAllDetailRegist();
		model.addAttribute("listRegist", listRegist);
		model.addAttribute("listDetailRegist", listDetailRegist);
		return "detailRegist";
	}

}
