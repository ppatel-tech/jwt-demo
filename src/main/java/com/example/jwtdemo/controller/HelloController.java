package com.example.jwtdemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello jwt project";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public String user() {
		return "Hello user !";
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String admin() {
		return "hello admin" ;
	}
	
	
}
