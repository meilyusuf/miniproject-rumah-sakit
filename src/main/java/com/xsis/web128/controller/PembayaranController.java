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

import com.xsis.web128.entity.DetilObat;
import com.xsis.web128.entity.Obat;
import com.xsis.web128.entity.Pasien;
import com.xsis.web128.entity.Pembayaran;
import com.xsis.web128.service.PembayaranService;

@Controller
@RequestMapping("/pembayaran")
public class PembayaranController {

	@Autowired
	PembayaranService pembayaranService;
	
	@RequestMapping
	public String index() {
		return "pembayaran";
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Pasien getPasienByRegis(@PathVariable int id) {
		Pasien listPasien = pembayaranService.getPasienByRegis(id);
		return listPasien;	
	}
	
	@RequestMapping(value="getDetilObat/{id}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<DetilObat> getDetilObatByRegis(@PathVariable int id){
		List<DetilObat> listDetilObat = pembayaranService.getDetilObatByRegis(id);
		return listDetilObat;
	}
	
	@RequestMapping(value="savePembayaran",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void savePembayaran(@RequestBody Pembayaran pembayaran) {
		pembayaranService.savePembayaran(pembayaran);
	}
}