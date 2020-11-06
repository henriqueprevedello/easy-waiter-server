package br.com.easywaiter.server.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.ClienteController;
import br.com.easywaiter.server.service.UsuarioService;
import br.com.easywaiter.server.util.dto.UsuarioDTO;

@RestController
public class ClienteControllerImpl implements ClienteController {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public ResponseEntity<Void> cadastrar(UsuarioDTO usuarioDTO) {

		usuarioService.registrarCliente(usuarioDTO);

		return ResponseEntity.ok().build();
	}

}
