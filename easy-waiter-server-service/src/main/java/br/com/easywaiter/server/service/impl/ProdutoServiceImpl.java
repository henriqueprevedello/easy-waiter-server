package br.com.easywaiter.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easywaiter.server.repository.domain.Produto;
import br.com.easywaiter.server.repository.jpa.ProdutoRepository;
import br.com.easywaiter.server.service.ProdutoService;
import br.com.easywaiter.server.util.dto.ProdutoDTO;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void adicionar(ProdutoDTO produtoDTO) {

		Produto produto = new Produto();
		produto.setNome(produtoDTO.getNome());
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setValor(produtoDTO.getValor());
		produto.setAtivo(produtoDTO.getAtivo());

		produtoRepository.save(produto);
	}

	@Override
	public List<Produto> adquirirTodos() {
		
		return produtoRepository.findAll();
	}

}
