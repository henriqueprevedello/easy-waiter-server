package br.com.easywaiter.server.service;

import br.com.easywaiter.server.util.dto.CategoriaDTO;

public interface CategoriaService {

	void cadastrar(CategoriaDTO categoriaDTO, Long codigoEstabelecimento);

}
