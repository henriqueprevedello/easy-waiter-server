package br.com.easywaiter.server.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.CategoriaController;
import br.com.easywaiter.server.configuration.TokenService;
import br.com.easywaiter.server.service.CategoriaService;
import br.com.easywaiter.server.util.dto.CategoriaDTO;

@RestController
public class CategoriaControllerImpl implements CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private TokenService tokenService;

	@Override
	public ResponseEntity<Void> cadastrar(CategoriaDTO categoriaDTO, String token) {

		categoriaService.cadastrar(categoriaDTO, tokenService.getIdUsuarioPorHeader(token));

		return ResponseEntity.ok().build();

	}

	@Override
	public ResponseEntity<List<CategoriaDTO>> adquirirPorEstabelecimento(String token) {

		return ResponseEntity
				.ok(categoriaService.adquirirPorEstabelecimento(tokenService.getIdUsuarioPorHeader(token)));
	}

	@Override
	public ResponseEntity<Void> editar(CategoriaDTO categoriaDTO) throws Exception {

		categoriaService.editar(categoriaDTO);

		return ResponseEntity.ok().build();
	}

}
