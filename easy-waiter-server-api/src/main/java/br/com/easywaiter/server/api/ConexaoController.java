package br.com.easywaiter.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/conexao")
public interface ConexaoController {

	@GetMapping
	public ResponseEntity<Void> testar();

}
