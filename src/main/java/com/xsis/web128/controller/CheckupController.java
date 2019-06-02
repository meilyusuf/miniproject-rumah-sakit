package com.xsis.web128.controller;

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

import com.xsis.web128.entity.CheckUp;
import com.xsis.web128.entity.DetilKamar;
import com.xsis.web128.entity.DetilObat;
import com.xsis.web128.entity.Kamar;
import com.xsis.web128.entity.Obat;
import com.xsis.web128.entity.Pasien;
import com.xsis.web128.service.CheckupService;
import com.xsis.web128.service.KamarService;
import com.xsis.web128.service.ObatService;

@Controller
@RequestMapping("/checkup")
public class CheckupController {

	@Autowired
	CheckupService checkupService;
	
	@Autowired
	KamarService kamarSerice;
	
	@Autowired
	ObatService obatService;
	
	@RequestMapping
	public String index(Model model) {
		List<Obat> listObat = obatService.getAllObat();
		model.addAttribute("listobat", listObat);
		return "checkup";
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Pasien getPasienByRegis(@PathVariable int id) {
		return checkupService.getPasienByRegis(id);
	}
	
	@RequestMapping(value="/getKamarByTipe/{id}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Kamar> getKamarByTipe(@PathVariable int id) {
		List<Kamar> listKamar = checkupService.getKamarByTipe(id);		
		return listKamar;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void save(@RequestBody CheckUp checkup) {
		checkupService.save(checkup);
	}
	
	@RequestMapping(value="/cekDetilKamarByRegis/{id}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Kamar cekDetilKamarByRegis(@PathVariable int id) {
		return checkupService.cekDetilKamarByRegis(id);
	}
	
}
