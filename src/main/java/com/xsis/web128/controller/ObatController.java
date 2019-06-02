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

import com.xsis.web128.entity.Kamar;
import com.xsis.web128.entity.Obat;
import com.xsis.web128.service.ObatService;

@Controller
@RequestMapping("/obat")
public class ObatController {

	@Autowired
	ObatService obatService;
	
	@RequestMapping
	public String index(Model model) {
		List<Obat> listObat=obatService.getAllObat();
		model.addAttribute("listObat", listObat);
		return "obat";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute Obat obat) {
		obatService.save(obat);
		return "redirect:/obat";
	}
	
	@RequestMapping(value="/checkName/{name}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public boolean getObatByName(@PathVariable String name) {
		return obatService.getObatByName(name);
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Obat obat) {
		obatService.update(obat);
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@RequestBody Obat obat) {
		obatService.delete(obat);
	}
}
