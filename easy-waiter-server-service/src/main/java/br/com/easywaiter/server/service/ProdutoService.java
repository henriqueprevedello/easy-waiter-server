package br.com.easywaiter.server.service;

import java.util.List;

import br.com.easywaiter.server.util.dto.ProdutoDTO;

public interface ProdutoService {

	void adicionar(ProdutoDTO produtoDTO, Long codigoEstabelecimento);

	List<ProdutoDTO> adquirirTodos(Long codigoEstabelecimento);

	ProdutoDTO adquirir(Long codigoProduto) throws Exception;

	Integer adquirirQuantidadeDeProdutosValidosDeUmaCategoria(Long codigoCategoria);

	void excluir(Long codigoProduto) throws Exception;

	void editar(ProdutoDTO produtoDTO) throws Exception;

}
