package com.nay.firstSpring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

	@GetMapping(path = "/ola")
	public String ola() {
		return "Olá Spring :)";
	}
	
	@PostMapping(path = "/oi")
	public String alo() {
		return "Alô Spring :)";
	}
}
