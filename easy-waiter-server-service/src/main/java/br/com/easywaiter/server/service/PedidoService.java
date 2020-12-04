package br.com.easywaiter.server.service;

import br.com.easywaiter.server.util.dto.PedidoDTO;

public interface PedidoService {

	Long adicionar(PedidoDTO pedidoDTO);

	PedidoDTO adquirir(Long codigoPedido);

}
