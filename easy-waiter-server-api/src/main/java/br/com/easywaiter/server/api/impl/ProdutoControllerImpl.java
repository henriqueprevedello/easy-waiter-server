package br.com.easywaiter.server.api.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.reflect.TypeToken;

import br.com.easywaiter.server.api.ProdutoController;
import br.com.easywaiter.server.service.ProdutoService;
import br.com.easywaiter.server.util.dto.ProdutoDTO;

@RestController
public class ProdutoControllerImpl implements ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseEntity<Void> adicionar(ProdutoDTO produtoDTO) {

		produtoService.adicionar(produtoDTO);

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<ProdutoDTO>> adquirirTodos() {

		return ResponseEntity.ok(modelMapper.map(produtoService.adquirirTodos(),
				TypeToken.getParameterized(List.class, ProdutoDTO.class).getType()));
	}

}
