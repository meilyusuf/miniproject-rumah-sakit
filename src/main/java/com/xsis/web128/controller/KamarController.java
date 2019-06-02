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
import com.xsis.web128.service.KamarService;

@Controller
@RequestMapping("/kamar")
public class KamarController {

	@Autowired
	KamarService kamarService;
	
	@RequestMapping
	public String index(Model model) {
		List<Kamar> listKamar = kamarService.getAllKamar();
		model.addAttribute("listKamar", listKamar);
		return "kamar";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public boolean save(@RequestBody Kamar kamar) {
		boolean a = kamarService.save(kamar);
		if(a==true) {
			return a;
		}
		return false;
	}
	
	@RequestMapping(value="/checkNo/{noKamar}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public boolean getKamarByNomor(@PathVariable int noKamar) {
		return kamarService.getKamarByNomor(noKamar);
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Kamar kamar) {
		kamarService.update(kamar);
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@RequestBody Kamar kamar) {
		kamarService.delete(kamar);
	}
}
