package br.com.easywaiter.server.service.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	public void cadastrar(Long numeroMesa, Long codigoEstabelecimento) throws Exception {

		Optional<Mesa> optionalMesa = mesaRepository.findFirstByNumero(numeroMesa);

		if (optionalMesa.isPresent()) {

			throw new Exception("Mesa já cadastrada");
		}

		Mesa mesa = new Mesa();
		mesa.setNumero(numeroMesa);
		mesa.setCodigoEstabelecimento(codigoEstabelecimento);

		mesaRepository.save(mesa);
	}

	@Override
	public List<MesaDTO> adquirirPorEstabelecimento(Long codigoEstabelecimento) {

		return modelMapper.map(
				mesaRepository.findByCodigoEstabelecimentoAndDataExclusaoIsNullOrderByNumeroAsc(codigoEstabelecimento),
				TypeToken.getParameterized(List.class, MesaDTO.class).getType());
	}

	@Override
	public void excluir(Long codigoMesa) throws Exception {
		Optional<Mesa> optionalMesa = mesaRepository.findById(codigoMesa);

		if (!optionalMesa.isPresent()) {

			throw new Exception("Mesa não encontrada");
		}

		Mesa mesa = optionalMesa.get();
		mesa.setDataExclusao(Date.from(Instant.now()));

		mesaRepository.save(mesa);
	}

	@Override
	public void editar(MesaDTO mesaDTO) throws Exception {

		Optional<Mesa> optionalMesaComNumero = mesaRepository.findFirstByNumero(mesaDTO.getNumero());

		if (optionalMesaComNumero.isPresent()) {

			throw new Exception("Mesa já cadastrada");
		}

		Optional<Mesa> optionalMesa = mesaRepository.findById(mesaDTO.getId());

		if (!optionalMesa.isPresent()) {

			throw new Exception("Mesa não encontrada");
		}

		Mesa mesa = optionalMesa.get();
		mesa.setNumero(mesaDTO.getNumero());

		mesaRepository.save(mesa);
	}

	@Override
	public void ocupar(Long idMesa) throws Exception {

		this.alterarDisponibilidade(idMesa, true);
	}

	@Override
	public void desocupar(Long idMesa) throws Exception {

		this.alterarDisponibilidade(idMesa, false);
	}

	private void alterarDisponibilidade(Long idMesa, Boolean ocupado) throws Exception {
		Mesa mesa = mesaRepository.findById(idMesa).orElseThrow(() -> new Exception("Mesa não encontrada"));

		mesa.setOcupado(ocupado);

		mesaRepository.save(mesa);
	}

}
