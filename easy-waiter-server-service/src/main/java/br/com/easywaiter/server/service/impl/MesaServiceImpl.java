package br.com.easywaiter.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

import br.com.easywaiter.server.repository.domain.Mesa;
import br.com.easywaiter.server.repository.jpa.MesaRepository;
import br.com.easywaiter.server.service.MesaService;
import br.com.easywaiter.server.util.dto.MesaDTO;

@Service
public class MesaServiceImpl implements MesaService {

	@Autowired
	private MesaRepository mesaRepository;

	@Autowired
	private ModelMapper modelMapper;

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

	@Override
	public List<MesaDTO> adquirirPorEstabelecimento(Long codigoEstabelecimento) {

		return modelMapper.map(mesaRepository.findByCodigoEstabelecimento(codigoEstabelecimento),
				TypeToken.getParameterized(List.class, MesaDTO.class).getType());
	}

}
