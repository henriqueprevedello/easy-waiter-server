package br.com.easywaiter.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.easywaiter.server.util.dto.UsuarioDTO;

@RequestMapping(value = "/cliente")
public interface ClienteController {

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody UsuarioDTO usuarioDTO);

}
