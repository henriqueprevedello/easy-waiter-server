package br.com.easywaiter.server.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.easywaiter.server.util.dto.ProdutoDTO;

@RequestMapping(value = "/produto")
public interface ProdutoController {

	@PostMapping
	public ResponseEntity<Void> adicionar(@RequestBody ProdutoDTO produtoDTO);
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> adquirirTodos();

}
