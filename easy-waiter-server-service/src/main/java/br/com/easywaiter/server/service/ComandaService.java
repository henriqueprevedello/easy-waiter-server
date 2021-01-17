package br.com.easywaiter.server.service;

import java.util.List;

import br.com.easywaiter.server.repository.domain.Comanda;
import br.com.easywaiter.server.util.dto.ComandaDTO;

public interface ComandaService {

	Comanda adquirirOuAbrir(Long codigoCliente, Long codigoEstabelecimento, Long codigoMesa);

	List<ComandaDTO> adquirir(Long codigoEstabelecimento);

}
