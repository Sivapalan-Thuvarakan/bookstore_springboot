package com.learning.bookstore.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.learning.bookstore.entity.User;
import com.learning.bookstore.response.AccessDeniedException;

import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtills {

	private static String secret="secret";
	private static long expireDuration =60 * 60;
	
	public String generateKey(User user)
	{
		long millitime = System.currentTimeMillis();
		Date issuedAt = new Date(millitime);
		long expiredtime= millitime + expireDuration*1000;
		Date expiredAt = new Date(expiredtime);
		
		//Claims
		Claims claims = Jwts.claims()
				.setIssuedAt(issuedAt)
				.setIssuer(user.getId().toString())
				.setExpiration(expiredAt);
		//optional claims don't add sensitive data of systems
		claims.put("Type", user.getUserType());
		claims.put("Gender",user.getGender());
		claims.put("EmailId", user.getEmailId());
		
		//generate jet using claims
		return Jwts.builder().setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	
	}
	
	//to verify token
	public void verify(String authentication) throws Exception
	{
		try {
		Jwts.parser().setSigningKey(secret).parseClaimsJws(authentication);
		}catch(Exception e) {
			throw new AccessDeniedException("Access Denied");
		}
	}
}
