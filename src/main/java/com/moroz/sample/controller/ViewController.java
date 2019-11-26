package com.moroz.sample.controller;

import com.moroz.sample.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {

	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("persons", personRepository.findAll());
		return "index";
	}
}
