package br.com.easywaiter.server.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/mesa")
public interface MesaController {

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody List<Long> listaMesas,
			@RequestHeader(name = "Authorization") String token);

}
