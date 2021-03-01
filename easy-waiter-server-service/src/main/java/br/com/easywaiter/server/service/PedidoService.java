package br.com.easywaiter.server.service;

import java.util.List;

import br.com.easywaiter.server.util.dto.PedidoDTO;

public interface PedidoService {

	Long adicionar(PedidoDTO pedidoDTO);

	PedidoDTO adquirirDTO(Long codigoPedido);

	List<PedidoDTO> adquirirNaoFinalizados(Long codigoEstabelecimento);

	void prosseguir(Long codigoPedido) throws Exception;

	void recusar(Long codigoPedido) throws Exception;

}
