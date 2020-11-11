package br.com.easywaiter.server.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easywaiter.server.repository.domain.Comanda;
import br.com.easywaiter.server.repository.jpa.ComandaRepository;
import br.com.easywaiter.server.service.ComandaService;

@Service
public class ComandaServiceImpl implements ComandaService {

	@Autowired
	private ComandaRepository comandaRepository;

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

}
