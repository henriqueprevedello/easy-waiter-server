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
import br.com.easywaiter.server.util.dto.EstabelecimentoDTO;
import br.com.easywaiter.server.util.dto.LocalizacaoDTO;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EstabelecimentoDTO adquirir(Long codigoEstabelecimento) {
		Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoRepository.findById(codigoEstabelecimento);

		if (optionalEstabelecimento.isPresent()) {

			return modelMapper.map(optionalEstabelecimento.get(), EstabelecimentoDTO.class);
		}

		return null;
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

		return modelMapper.map(estabelecimentoRepository.findByCidadeAndEstado(cidade, estado),
				TypeToken.getParameterized(List.class, EstabelecimentoDTO.class).getType());

	}

}
