package br.com.easywaiter.server.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.AutenticacaoController;
import br.com.easywaiter.server.configuration.TokenService;
import br.com.easywaiter.server.util.dto.AutenticacaoDTO;
import br.com.easywaiter.server.util.dto.TokenDTO;

@RestController
public class AutenticacaoControllerImpl implements AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;

	@Override
	public ResponseEntity<TokenDTO> login(AutenticacaoDTO autenticacaoDTO) {

		UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(
				autenticacaoDTO.getEmail(), autenticacaoDTO.getSenha());

		try {

			Authentication authentication = authManager.authenticate(dadosLogin);

			String token = tokenService.gerar(authentication);

			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));

		} catch (AuthenticationException e) {

			return ResponseEntity.badRequest().build();
		}

	}

}
