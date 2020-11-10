package br.com.easywaiter.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

import br.com.easywaiter.server.repository.domain.Estabelecimento;
import br.com.easywaiter.server.repository.jpa.EstabelecimentoRepository;
import br.com.easywaiter.server.service.EstabelecimentoService;
import br.com.easywaiter.server.service.UsuarioService;
import br.com.easywaiter.server.util.dto.EstabelecimentoDTO;
import br.com.easywaiter.server.util.dto.LocalizacaoDTO;
import br.com.easywaiter.server.util.dto.ProdutoDTO;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EstabelecimentoDTO editar(EstabelecimentoDTO estabelecimentoDTO) throws Exception {

		usuarioService.editarNome(estabelecimentoDTO.getNome(), estabelecimentoDTO.getCodigoEstabelecimento());

		Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoRepository
				.findById(estabelecimentoDTO.getCodigoEstabelecimento());

		if (!optionalEstabelecimento.isPresent()) {
			throw new Exception("Não encontrado estabelecimento!");
		}

		Estabelecimento estabelecimento = optionalEstabelecimento.get();

		estabelecimento.setDescricao(estabelecimentoDTO.getDescricao());
		estabelecimento.setNumeroTelefone(estabelecimentoDTO.getNumeroTelefone());

		return modelMapper.map(estabelecimentoRepository.save(estabelecimento), EstabelecimentoDTO.class);

	}

	@Override
	public EstabelecimentoDTO adquirir(Long codigoEstabelecimento) {
		Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoRepository.findById(codigoEstabelecimento);

		if (!optionalEstabelecimento.isPresent()) {
			return null;
		}

		EstabelecimentoDTO estabelecimentoDTO = modelMapper.map(optionalEstabelecimento.get(),
				EstabelecimentoDTO.class);

		estabelecimentoDTO.getCategorias().forEach(categoria -> {

			List<ProdutoDTO> listaProdutos = new ArrayList<>();

			estabelecimentoDTO.getProdutos().forEach(produto -> {

				if (produto.getCategoria() != null && produto.getCategoria().getId().equals(categoria.getId())) {

					produto.setCategoria(null);

					listaProdutos.add(produto);
				}

			});

			categoria.setProdutos(listaProdutos);
		});

		return estabelecimentoDTO;
	}

	@Override
	public List<LocalizacaoDTO> adquirirLocalizacoes() {

		List<LocalizacaoDTO> listaLocalizacao = new ArrayList<>();

		List<Estabelecimento> listaEstabelecimentos = estabelecimentoRepository.findAll();

		listaEstabelecimentos.forEach(estabelecimento -> {
			if (!this.containsCidade(listaLocalizacao, estabelecimento.getCidade(), estabelecimento.getEstado())) {
				listaLocalizacao.add(new LocalizacaoDTO(estabelecimento.getCidade(), estabelecimento.getEstado()));
			}
		});

		return listaLocalizacao;

	}

	public boolean containsCidade(final List<LocalizacaoDTO> list, final String cidade, final String estado) {

		return list.stream().filter(o -> o.getCidade().equals(cidade) && o.getEstado().equals(estado)).findFirst()
				.isPresent();
	}

	@Override
	public List<EstabelecimentoDTO> adquirirPorLocalizacao(String cidade, String estado) {

		List<Estabelecimento> listaEstabelecimentos = estabelecimentoRepository.findByCidadeAndEstado(cidade, estado);

		return modelMapper.map(listaEstabelecimentos,
				TypeToken.getParameterized(List.class, EstabelecimentoDTO.class).getType());

	}

}
