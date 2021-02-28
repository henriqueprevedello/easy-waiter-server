package br.com.easywaiter.server.service;

import java.util.List;

import br.com.easywaiter.server.util.dto.CategoriaDTO;

public interface CategoriaService {

	void cadastrar(CategoriaDTO categoriaDTO, Long codigoEstabelecimento);

	void editar(CategoriaDTO categoriaDTO) throws Exception;

	void excluir(Long codigoCategoria) throws Exception;

	List<CategoriaDTO> adquirirPorEstabelecimento(Long codigoEstabelecimento);

}
