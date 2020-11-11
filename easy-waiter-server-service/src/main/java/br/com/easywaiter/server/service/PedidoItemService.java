package br.com.easywaiter.server.service;

import java.util.List;

import br.com.easywaiter.server.util.dto.PedidoItemDTO;

public interface PedidoItemService {

	void salvar(List<PedidoItemDTO> pedidoItens, Long codigoPedido);

}
