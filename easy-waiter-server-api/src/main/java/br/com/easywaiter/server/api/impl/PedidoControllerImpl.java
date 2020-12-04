package br.com.easywaiter.server.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.PedidoController;
import br.com.easywaiter.server.configuration.TokenService;
import br.com.easywaiter.server.service.PedidoService;
import br.com.easywaiter.server.util.dto.PedidoDTO;

@RestController
public class PedidoControllerImpl implements PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private TokenService tokenService;

	@Override
	public ResponseEntity<Long> adicionar(PedidoDTO pedidoDTO, String token) {

		pedidoDTO.setCodigoCliente(tokenService.getIdUsuarioPorHeader(token));

		return ResponseEntity.ok(pedidoService.adicionar(pedidoDTO));
	}

	@Override
	public ResponseEntity<PedidoDTO> adquirir(Long codigoPedido) {

		return ResponseEntity.ok(pedidoService.adquirir(codigoPedido));
	}

}
