package br.com.easywaiter.server.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.AutenticacaoController;
import br.com.easywaiter.server.repository.domain.Usuario;
import br.com.easywaiter.server.service.impl.TokenService;
import br.com.easywaiter.server.util.dto.AutenticacaoDTO;
import br.com.easywaiter.server.util.dto.UsuarioDTO;

@RestController
public class AutenticacaoControllerImpl implements AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;

	@Override
	public ResponseEntity<UsuarioDTO> login(AutenticacaoDTO autenticacaoDTO) {

		UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(
				autenticacaoDTO.getEmail(), autenticacaoDTO.getSenha());

		try {

			Authentication authentication = authManager.authenticate(dadosLogin);

			Usuario usuario = (Usuario) authentication.getPrincipal();

			String token = tokenService.gerar(usuario);

			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setNome(usuario.getNome());
			usuarioDTO.setEmail(usuario.getEmail());

			usuarioDTO.setToken(token);

			return ResponseEntity.ok(usuarioDTO);

		} catch (AuthenticationException e) {

			return ResponseEntity.badRequest().build();
		}

	}

}
