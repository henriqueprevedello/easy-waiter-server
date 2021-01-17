package br.com.easywaiter.server.service;

import java.util.List;

import br.com.easywaiter.server.util.dto.PedidoDTO;

public interface PedidoService {

	Long adicionar(PedidoDTO pedidoDTO);

	PedidoDTO adquirir(Long codigoPedido);

	List<PedidoDTO> adquirirNaoFinalizados(Long codigoEstabelecimento);

}
