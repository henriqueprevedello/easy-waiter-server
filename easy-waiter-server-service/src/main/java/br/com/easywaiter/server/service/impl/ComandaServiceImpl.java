package br.com.easywaiter.server.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

import br.com.easywaiter.server.repository.domain.Comanda;
import br.com.easywaiter.server.repository.jpa.ComandaRepository;
import br.com.easywaiter.server.service.ComandaService;
import br.com.easywaiter.server.util.dto.ComandaDTO;

@Service
public class ComandaServiceImpl implements ComandaService {

	@Autowired
	private ComandaRepository comandaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Comanda adquirirOuAbrir(Long codigoCliente, Long codigoEstabelecimento, Long codigoMesa) {

		Optional<Comanda> optionalComanda = comandaRepository.findByDataFechamentoIsNullAndCodigoCliente(codigoCliente);

		if (optionalComanda.isPresent()) {

			return optionalComanda.get();
		}

		Comanda comanda = new Comanda();
		comanda.setCodigoCliente(codigoCliente);
		comanda.setCodigoEstabelecimento(codigoEstabelecimento);
		comanda.setCodigoMesa(codigoMesa);

		return comandaRepository.save(comanda);
	}

	@Override
	public List<ComandaDTO> adquirir(Long codigoEstabelecimento) {

		return modelMapper.map(comandaRepository.findByCodigoEstabelecimento(codigoEstabelecimento),
				TypeToken.getParameterized(List.class, ComandaDTO.class).getType());
	}

}
