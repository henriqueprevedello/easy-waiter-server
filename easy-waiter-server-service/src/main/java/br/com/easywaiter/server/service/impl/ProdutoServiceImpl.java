package br.com.easywaiter.server.service.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

import br.com.easywaiter.server.repository.domain.Produto;
import br.com.easywaiter.server.repository.jpa.ProdutoRepository;
import br.com.easywaiter.server.service.ProdutoService;
import br.com.easywaiter.server.util.dto.ProdutoDTO;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void adicionar(ProdutoDTO produtoDTO, Long codigoEstabelecimento) {

		Produto produto = new Produto();
		produto.setNome(produtoDTO.getNome());
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setValor(produtoDTO.getValor());
		produto.setAtivo(produtoDTO.getAtivo());
		produto.setCodigoCategoria(produtoDTO.getCodigoCategoria());
		produto.setCodigoEstabelecimento(codigoEstabelecimento);
		produto.setImagem(produtoDTO.getImagem());

		produtoRepository.save(produto);
	}

	@Override
	public List<ProdutoDTO> adquirirNaoExcluidos(Long codigoEstabelecimento) {

		return modelMapper.map(produtoRepository.findAllByCodigoEstabelecimentoAndDataExclusaoIsNullOrderByIdDesc(
				codigoEstabelecimento), TypeToken.getParameterized(List.class, ProdutoDTO.class).getType());

	}

	@Override
	public List<ProdutoDTO> adquirirNaoExcluidosEAtivos(Long codigoEstabelecimento) {

		return modelMapper.map(produtoRepository
				.findAllByCodigoEstabelecimentoAndDataExclusaoIsNullAndAtivoIsTrueOrderByIdDesc(codigoEstabelecimento),
				TypeToken.getParameterized(List.class, ProdutoDTO.class).getType());

	}

	@Override
	public ProdutoDTO adquirir(Long codigoProduto) throws Exception {

		Optional<Produto> optionalProduto = produtoRepository.findById(codigoProduto);

		if (optionalProduto.isPresent()) {

			return modelMapper.map(optionalProduto.get(), ProdutoDTO.class);
		}

		throw new Exception("Produto não encontrado");
	}

	@Override
	public Integer adquirirQuantidadeDeProdutosValidosDeUmaCategoria(Long codigoCategoria) {

		return produtoRepository.countByCodigoCategoriaAndDataExclusaoIsNullAndAtivoIsTrue(codigoCategoria);
	}

	@Override
	public void excluir(Long codigoProduto) throws Exception {
		Optional<Produto> optionalProduto = produtoRepository.findById(codigoProduto);

		if (!optionalProduto.isPresent()) {
			throw new Exception("Produto não encontrado");
		}

		Produto produto = optionalProduto.get();
		produto.setDataExclusao(Date.from(Instant.now()));

		produtoRepository.save(produto);
	}

	@Override
	public void editar(ProdutoDTO produtoDTO) throws Exception {
		Optional<Produto> optionalProduto = produtoRepository.findById(produtoDTO.getId());

		if (!optionalProduto.isPresent()) {
			throw new Exception("Produto não encontrado");
		}

		Produto produto = optionalProduto.get();
		produto.setNome(produtoDTO.getNome());
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setAtivo(produtoDTO.getAtivo());
		produto.setCodigoCategoria(produtoDTO.getCodigoCategoria());
		produto.setValor(produtoDTO.getValor());

		if (produtoDTO.getImagem() != null) {
			produto.setImagem(produtoDTO.getImagem());
		}

		produtoRepository.save(produto);
	}

}
