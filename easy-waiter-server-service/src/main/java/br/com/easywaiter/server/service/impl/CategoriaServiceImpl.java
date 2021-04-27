package br.com.easywaiter.server.service.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

import br.com.easywaiter.server.repository.domain.Categoria;
import br.com.easywaiter.server.repository.jpa.CategoriaRepository;
import br.com.easywaiter.server.service.CategoriaService;
import br.com.easywaiter.server.service.ProdutoService;
import br.com.easywaiter.server.util.dto.CategoriaDTO;
import br.com.easywaiter.server.util.dto.ProdutoDTO;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void cadastrar(CategoriaDTO categoriaDTO, Long codigoEstabelecimento) {

		Categoria categoria = new Categoria();
		categoria.setCodigoEstabelecimento(codigoEstabelecimento);
		categoria.setNome(categoriaDTO.getNome());

		categoriaRepository.save(categoria);

	}

	@Override
	public List<CategoriaDTO> adquirirPorEstabelecimento(Long codigoEstabelecimento) {

		return modelMapper.map(categoriaRepository.findByCodigoEstabelecimentoAndDataExclusaoIsNullOrderByIdDesc(
				codigoEstabelecimento), TypeToken.getParameterized(List.class, CategoriaDTO.class).getType());
	}

	@Override
	public void editar(CategoriaDTO categoriaDTO) throws Exception {

		Optional<Categoria> optionalCategoria = categoriaRepository.findById(categoriaDTO.getId());

		if (!optionalCategoria.isPresent()) {
			throw new Exception("Categoria não encontrada");
		}

		Categoria categoria = optionalCategoria.get();
		categoria.setNome(categoriaDTO.getNome());

		categoriaRepository.save(categoria);
	}

	@Override
	public void excluir(Long codigoCategoria) throws Exception {
		Optional<Categoria> optionalCategoria = categoriaRepository.findById(codigoCategoria);

		if (!optionalCategoria.isPresent()) {
			throw new Exception("Categoria não encontrada");
		}

		Categoria categoria = optionalCategoria.get();

		if (produtoService.adquirirQuantidadeDeProdutosValidosDeUmaCategoria(categoria.getId()) > 0) {

			throw new Exception("Não é possível excluir a categoria pois possui produtos vinculados");
		}

		categoria.setDataExclusao(Date.from(Instant.now()));

		categoriaRepository.save(categoria);

	}

	@Override
	public List<CategoriaDTO> adquirirCategoriasEProdutosDisponiveis(Long codigoEstabelecimento) {

		List<CategoriaDTO> listaCategoriaDTO = modelMapper.map(
				categoriaRepository.adquirirCategoriasEProdutosDisponiveis(codigoEstabelecimento),
				TypeToken.getParameterized(List.class, CategoriaDTO.class).getType());

		List<ProdutoDTO> produtos = produtoService.adquirirNaoExcluidosEAtivos(codigoEstabelecimento);

		listaCategoriaDTO.forEach(categoria -> {

			List<ProdutoDTO> listaProdutos = new ArrayList<>();

			produtos.forEach(produto -> {

				if (produto.getCategoria() != null && produto.getCategoria().getId().equals(categoria.getId())) {

					produto.setCategoria(null);

					listaProdutos.add(produto);
				}

			});

			categoria.setProdutos(listaProdutos);
		});

		return listaCategoriaDTO;
	}

}
