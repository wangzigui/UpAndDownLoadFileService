package com.nf.util;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenService {

	public String createJWT(String id, String issuer, String subject, long ttlMillis) {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("wangzigui");
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);

		// if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		builder.claim("role", "admin");
		// builder.s
		// builder.setHeaderParam("aaaa","sss");
		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public Claims parseJWT(String jwt) {
		// This line will throw an exception if it is not a signed JWS (as
		// expected)

		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("wangzigui"))
				.parseClaimsJws(jwt).getBody();
		Object obj = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("wangzigui")).parse(jwt).getBody();
		System.out.println(obj.toString());

		// claims.ge
		System.out.println("ID: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Issuer: " + claims.getIssuer());
		System.out.println("Expiration: " + claims.getExpiration());
		System.out.println("role: " + claims.get("role"));
		
		return claims;
	}

	public static void main(String[] args) {
		TokenService TokenService = new TokenService();
		String token = TokenService.createJWT("123456", "wangzigui", "aaaa", 10000);
		System.out.println(token);
		TokenService.parseJWT(token);

	}
}
