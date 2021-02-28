package br.com.easywaiter.server.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.ProdutoController;
import br.com.easywaiter.server.configuration.TokenService;
import br.com.easywaiter.server.service.ProdutoService;
import br.com.easywaiter.server.util.dto.ProdutoDTO;

@RestController
public class ProdutoControllerImpl implements ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private TokenService tokenService;

	@Override
	public ResponseEntity<Void> adicionar(ProdutoDTO produtoDTO, String token) {

		produtoService.adicionar(produtoDTO, tokenService.getIdUsuarioPorHeader(token));

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<ProdutoDTO> adquirir(Long codigoProduto) throws Exception {

		return ResponseEntity.ok(produtoService.adquirir(codigoProduto));
	}

	@Override
	public ResponseEntity<List<ProdutoDTO>> adquirirTodos(String token) {

		return ResponseEntity.ok(produtoService.adquirirTodos(tokenService.getIdUsuarioPorHeader(token)));
	}

}
