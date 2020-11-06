package br.com.easywaiter.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.easywaiter.server.util.dto.CategoriaDTO;

@RequestMapping(value = "/categoria")
public interface CategoriaController {

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody CategoriaDTO categoriaDTO,
			@RequestHeader(name = "Authorization") String token);

}
