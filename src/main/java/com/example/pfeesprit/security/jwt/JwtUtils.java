package com.example.pfeesprit.security.jwt;

import java.util.Date;


import io.jsonwebtoken.SignatureAlgorithm;

import com.example.pfeesprit.security.services.UserDetailsImpl;
import io.helidon.config.objectmapping.Value;
import org.jboss.weld.exceptions.IllegalArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;


@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value(key = "${bezkoder.app.jwtSecret}")
	private String jwtSecret;

	@Value(key = "${bezkoder.app.jwtExpirationMs}")
	private long jwtExpirationMs = SecurityConstants.EXPIRATION_TIME;

	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512,SecurityConstants.SECRET)
				.compact();
	}


	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(SecurityConstants.SECRET).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(SecurityConstants.SECRET).parseClaimsJws(authToken);
			return true;
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}
	
		return false;
	}
}


