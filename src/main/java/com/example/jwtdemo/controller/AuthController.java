package com.example.jwtdemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtdemo.entity.User;
import com.example.jwtdemo.service.UserService;
import com.example.jwtdemo.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}

	@PostMapping("/login")
	public Map<String, String> login(@RequestBody User user) {

		User existingUser = userService.findByUsername(user.getUsername());

		if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {

			String token = JwtUtil.generateToken(existingUser.getUsername());
			Map<String , String> response = new HashMap<>();
			response.put("token", token);
			
			return response;

		}
		throw new RuntimeException("Invalid username and password");

	}

}
