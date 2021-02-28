package br.com.easywaiter.server.service;

import java.util.List;

import br.com.easywaiter.server.util.dto.MesaDTO;

public interface MesaService {

	void cadastrar(Long numeroMesa, Long codigoEstabelecimento) throws Exception;

	List<MesaDTO> adquirirPorEstabelecimento(Long codigoEstabelecimento);

	void excluir(Long codigoMesa) throws Exception;

	void editar(MesaDTO mesaDTO) throws Exception;

}
