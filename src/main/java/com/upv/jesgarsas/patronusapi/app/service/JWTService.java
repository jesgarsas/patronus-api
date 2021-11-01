package com.upv.jesgarsas.patronusapi.app.service;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.utils.RolTypes;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;

@Service
public class JWTService {
	
	private static final String SECRET_KEY = "076e428464e2454a0a66d4603be4601a565e284ac81a53fd55df607e6837a1f5";
	
	private static final Logger LOG = LoggerFactory.getLogger(JWTService.class);
	
	private static final long EXPIRATION_TIME = TimeUnit.DAYS.toMillis(1);

	public String getJWTToken(String username, Integer rol, Integer id) {

		String token = Jwts.builder().setId("patronusLogin").setSubject(username)
				.claim("authorities", RolTypes.getRolById(rol))
				.claim("id", id)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(getHmacKey()).compact();

		return token;
	}
	
	public static Claims validateToken(HttpServletRequest request, String header) {
		String jwtToken = request.getHeader(header);
		try {
			return Jwts.parserBuilder().setSigningKey(getHmacKey()).build().parseClaimsJws(jwtToken).getBody();
		} catch (SignatureException e) {
			LOG.error("Bad token passed to JWT auth");
		} catch (ExpiredJwtException e) {
			// LOG.error("Expired token passed to JWT auth");
		} catch (UnsupportedJwtException e) {
			// LOG.error("Unsupported method passed to JWT auth");
		} catch (MalformedJwtException e) {
			// LOG.error("Malformed token passed to JWT auth");
		} catch (IllegalArgumentException e) {
			// LOG.error("Illegal Arguments passed to JWT auth");
		}
		return null;
	}
	
	public boolean isSameIdUser(String jwtToken, Integer id) {
		Claims claims = Jwts.parserBuilder().setSigningKey(getHmacKey()).build().parseClaimsJws(jwtToken).getBody();
		try {
			return claims.containsKey("id") && (((Integer) claims.get("id")).equals(id) || ((String) claims.get("authorities")).equals(RolTypes.ADMINISTRADOR));
		} catch (Exception e) {
			return false;
		}
	}

	private static SecretKeySpec getHmacKey() {
		return new SecretKeySpec(Base64.getDecoder().decode(SECRET_KEY), 
                SignatureAlgorithm.HS256.getJcaName());
	}
}