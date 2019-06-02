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


import com.xsis.web128.entity.Pasien;
import com.xsis.web128.service.PasienService;

@Controller
@RequestMapping("/pasien")
public class PasienController {
	
	@Autowired
	PasienService pasienService;
	
	//save
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void pasien(@RequestBody Pasien pasien) {
		pasienService.save(pasien);
	}
	
	//delete
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		Pasien pasien = new Pasien();
		pasien.setId(id);
		pasien.setName("del");
		pasienService.delete(pasien);
	}
	//mengambil data by ID // EDIT
	@ResponseBody
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Pasien getPasienById(@PathVariable int id) {
		Pasien pasien = pasienService.getPasienById(id);
		return pasien;
	}
	
	//update
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Pasien pasien) {
		pasienService.update(pasien);
	}
	

	//tampil data
		@RequestMapping
		public String index(Model model) {
			List<Pasien> listTrader = pasienService.getAllPasien();
			model.addAttribute("listTrader", listTrader);
			return "pasien";
		}
	
}
