package br.com.easywaiter.server.service;


import br.com.easywaiter.server.util.dto.PedidoDTO;

public interface PedidoService {
	
	void adicionar(PedidoDTO pedidoDTO, Long codigoUsuario);
	

}
