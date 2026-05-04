package com.ingrid.blogapi.service;

import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
//import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
//import java.security.Key;
import javax.crypto.SecretKey;
@Service
public class JwtService {


	//private static final SecretKey SECRET = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	 private final SecretKey SECRET;

	    public JwtService(@Value("${JWT_SECRET}") String secret) {
	        this.SECRET = Keys.hmacShaKeyFor(
	                io.jsonwebtoken.io.Decoders.BASE64.decode(secret)
	        );
	    }

    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SECRET)
                .compact();
    }

    public String extractUsername(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(SECRET)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername());
    }
}