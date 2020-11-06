package br.com.easywaiter.server.service;

import java.util.List;

public interface MesaService {

	void cadastrar(List<Long> listaMesas, Long codigoEstabelecimento);

}
