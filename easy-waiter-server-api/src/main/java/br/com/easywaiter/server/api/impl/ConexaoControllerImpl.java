package br.com.easywaiter.server.api.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.ConexaoController;

@RestController
public class ConexaoControllerImpl implements ConexaoController {

	@Override
	public ResponseEntity<Void> testar() {

		return ResponseEntity.ok().build();
	}

}
