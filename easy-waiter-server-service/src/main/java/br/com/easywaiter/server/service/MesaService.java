package br.com.easywaiter.server.service;

import java.util.List;

import br.com.easywaiter.server.util.dto.MesaDTO;

public interface MesaService {

	void cadastrar(List<Long> listaMesas, Long codigoEstabelecimento);

	List<MesaDTO> adquirirPorEstabelecimento(Long codigoEstabelecimento);

}
