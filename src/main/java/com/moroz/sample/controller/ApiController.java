package com.moroz.sample.controller;

import com.moroz.sample.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class ApiController {

	@Autowired
    private PersonRepository personRepository;
	
	@GetMapping
	public ResponseEntity<?> getPersons(){
		return ResponseEntity.ok(personRepository.findAll());
	}
}
