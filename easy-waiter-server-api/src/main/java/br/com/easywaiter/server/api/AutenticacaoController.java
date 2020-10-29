package br.com.easywaiter.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.easywaiter.server.util.dto.AutenticacaoDTO;
import br.com.easywaiter.server.util.dto.UsuarioDTO;

@RequestMapping(value = "/autenticacao")
public interface AutenticacaoController {

	@PostMapping
	public ResponseEntity<UsuarioDTO> login(@RequestBody AutenticacaoDTO autenticacaoDTO);

}
