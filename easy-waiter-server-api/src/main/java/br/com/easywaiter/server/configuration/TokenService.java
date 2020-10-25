package br.com.easywaiter.server.configuration;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.easywaiter.server.repository.domain.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${ews.jwt.expiration}")
	private String expiration;

	@Value("${ews.jwt.secret}")
	private String secret;

	public String gerar(Authentication authentication) {

		Usuario usuario = (Usuario) authentication.getPrincipal();

		Date agora = new Date();

		return Jwts.builder().setIssuer("EasyWaiterServer").setSubject(usuario.getId().toString()).setIssuedAt(agora)
				.setExpiration(new Date(agora.getTime() + Long.parseLong(expiration)))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

}
