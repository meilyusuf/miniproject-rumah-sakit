package com.xsis.web128.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.web128.entity.Dokter;
import com.xsis.web128.entity.JadwalPraktek;

@Controller
@RequestMapping("/index")
public class Index {
	
	@RequestMapping
	public String index(Model model) {
	
		return "index";
	}

}
