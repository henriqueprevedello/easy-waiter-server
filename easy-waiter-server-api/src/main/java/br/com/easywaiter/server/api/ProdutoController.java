package br.com.easywaiter.server.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.easywaiter.server.util.dto.ProdutoDTO;

@RequestMapping(value = "/produto")
public interface ProdutoController {

	@PostMapping
	public ResponseEntity<Void> adicionar(@RequestBody ProdutoDTO produtoDTO,
			@RequestHeader(name = "Authorization") String token);

	@GetMapping
	public ResponseEntity<ProdutoDTO> adquirir(@RequestParam(name = "codigoProduto") Long codigoProduto)
			throws Exception;

	@GetMapping(value = "/adquirirTodos")
	public ResponseEntity<List<ProdutoDTO>> adquirirTodos(@RequestHeader(name = "Authorization") String token);

	@PutMapping
	public ResponseEntity<Void> editar(@RequestBody ProdutoDTO produtoDTO) throws Exception;

	@DeleteMapping
	public ResponseEntity<Void> excluir(@RequestParam(value = "codigoProduto") Long codigoProduto) throws Exception;

}
