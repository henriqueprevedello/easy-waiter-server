package br.com.easywaiter.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easywaiter.server.repository.domain.Mesa;
import br.com.easywaiter.server.repository.jpa.MesaRepository;
import br.com.easywaiter.server.service.MesaService;

@Service
public class MesaServiceImpl implements MesaService {

	@Autowired
	private MesaRepository mesaRepository;

	@Override
	public void cadastrar(List<Long> listaMesas, Long codigoEstabelecimento) {

		List<Mesa> listaPersistir = new ArrayList<>();

		listaMesas.forEach(numeroMesa -> {
			Mesa mesa = new Mesa();
			mesa.setNumero(numeroMesa);
			mesa.setCodigoEstabelecimento(codigoEstabelecimento);

			listaPersistir.add(mesa);
		});

		mesaRepository.saveAll(listaPersistir);

	}

}
