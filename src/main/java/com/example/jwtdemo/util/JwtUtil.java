package com.example.jwtdemo.util;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	
	public static final String SECRET = "mysecretkeymysecretkeymysecretkey";
	
	private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
	
	public static String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))// 1 hour
				.signWith(key)
				.compact();
	}
}
