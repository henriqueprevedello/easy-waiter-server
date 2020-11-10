package br.com.easywaiter.server.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody CategoriaDTO categoriaDTO) throws Exception;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> adquirirPorEstabelecimento(
			@RequestHeader(name = "Authorization") String token);

}