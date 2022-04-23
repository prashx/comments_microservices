package com.prashant.commentSection.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil{// implements Serializable  {
	
	
	//final static Long serialVersionUID =1L;
	@Value("${jwt.secret}")
	private String secret;
	final static long TOKEN_VALIDITY=5 * 60 * 60;
	
	public String getUsernameFromToken(String token) {
		return getClaimFromJwtToken(token, Claims::getSubject);
	}
	

	public Date getExpirationDateFromToken(String token) {
			return getClaimFromJwtToken(token, Claims::getExpiration);
		}

		public <T> T getClaimFromJwtToken(String token, Function<Claims, T> claimFunction) {
			final Claims claims = getAllClaims(token);
			return claimFunction.apply(claims);
		}

		private Claims getAllClaims(String token) {
			return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		}

		private Boolean isTokenExpired(String token) {
			final Date expiration = getExpirationDateFromToken(token);
			return expiration.before(new Date());
		}
		
		//Set claims-issuer,expiry etc
		//generate token for user
		public String generateToken(UserDetails userDetails) {
			Map<String, Object> claims = new HashMap<>();
			return Jwts.builder().setClaims(claims).setIssuer("Prashant").setSubject( userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
					.signWith(SignatureAlgorithm.HS512, secret).compact();
		}


	

		//validate token
		public Boolean validateToken(String token, UserDetails userDetails) {
			final String username = getUsernameFromToken(token);
			return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
		}

}
