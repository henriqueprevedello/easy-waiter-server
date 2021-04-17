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

import br.com.easywaiter.server.util.dto.CategoriaDTO;

@RequestMapping(value = "/categoria")
public interface CategoriaController {

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody CategoriaDTO categoriaDTO,
			@RequestHeader(name = "Authorization") String token);

	@PutMapping
	public ResponseEntity<Void> editar(@RequestBody CategoriaDTO categoriaDTO) throws Exception;

	@DeleteMapping
	public ResponseEntity<Void> excluir(@RequestParam(value = "codigoCategoria") Long codigoCategoria) throws Exception;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> adquirirPorEstabelecimento(
			@RequestHeader(name = "Authorization") String token);

	@GetMapping(value = "/adquirirCategoriasEProdutosDisponiveis")
	public ResponseEntity<List<CategoriaDTO>> adquirirCategoriasEProdutosDisponiveis(
			@RequestParam(name = "codigoEstabelecimento") Long codigoEstabelecimento);

}
