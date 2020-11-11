package br.com.easywaiter.server.service;

import br.com.easywaiter.server.repository.domain.Comanda;

public interface ComandaService {

	Comanda adquirirOuAbrir(Long codigoCliente, Long codigoEstabelecimento, Long codigoMesa);

}
