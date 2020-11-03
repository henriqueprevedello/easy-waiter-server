package br.com.easywaiter.server.service;

import java.util.List;

import br.com.easywaiter.server.repository.domain.Produto;
import br.com.easywaiter.server.util.dto.ProdutoDTO;

public interface ProdutoService {
	
	void adicionar(ProdutoDTO produtoDTO);
	
	List<Produto> adquirirTodos();

}
