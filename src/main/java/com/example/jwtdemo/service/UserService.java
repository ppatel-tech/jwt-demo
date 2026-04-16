package com.example.jwtdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jwtdemo.entity.User;
import com.example.jwtdemo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	public User register(User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	    user.setRole(user.getRole());
		return userRepository.save(user);
	    
	}
	

}
