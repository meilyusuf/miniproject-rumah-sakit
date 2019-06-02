package com.xsis.web128.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.web128.entity.DataTrader;
import com.xsis.web128.entity.Dokter;
import com.xsis.web128.entity.JadwalPraktek;
import com.xsis.web128.entity.Pasien;
import com.xsis.web128.entity.Transaksi;
import com.xsis.web128.service.JadwalService;
import com.xsis.web128.service.PasienService;
import com.xsis.web128.service.DokterService;

@Controller
@RequestMapping("/jadwalPraktek")
public class JadwalController {

	@Autowired
	JadwalService jadwalService;
	
	@Autowired
	PasienService pasienService;
	
	@Autowired
	DokterService dokterService;
	
	@RequestMapping
	public String index(Model model){
		List<JadwalPraktek> listJadwal = jadwalService.getAllJadwal();
		List<Dokter> listDokter = dokterService.getAllDokter();
		model.addAttribute("listJadwal", listJadwal);
		model.addAttribute("listDokter", listDokter);
		return "jadwalPraktek";
	}	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		JadwalPraktek jadwalPraktek = new JadwalPraktek();
		jadwalPraktek.setId(id);
		jadwalPraktek.setHari("delete");;
		jadwalService.delete(jadwalPraktek);
	}
	
	@RequestMapping(value = "/get/{id}", method=RequestMethod.GET)
	@ResponseBody
	public JadwalPraktek getJadwalPraktekById(@PathVariable int id){
		JadwalPraktek jadwalPraktek = jadwalService.getJadwalPraktekById(id);
		return jadwalPraktek;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void edit(@RequestBody JadwalPraktek jadwalPraktek){
		jadwalService.update(jadwalPraktek);
	}
	
	/*@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute JadwalPraktek jadwalPraktek){
		
		jadwalService.save(jadwalPraktek);
		return "redirect:/jadwalPraktek";
	}*/
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void saveJadwal(@RequestBody JadwalPraktek jadwal) {

		jadwalService.save(jadwal);
	}
	
	
}