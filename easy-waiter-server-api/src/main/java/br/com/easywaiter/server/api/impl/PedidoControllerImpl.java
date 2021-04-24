package br.com.easywaiter.server.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.PedidoController;
import br.com.easywaiter.server.configuration.TokenService;
import br.com.easywaiter.server.service.PedidoService;
import br.com.easywaiter.server.util.dto.ListagemPedidoDTO;
import br.com.easywaiter.server.util.dto.PedidoDTO;

@RestController
public class PedidoControllerImpl implements PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private TokenService tokenService;

	@Override
	public ResponseEntity<Long> adicionar(PedidoDTO pedidoDTO, String token) throws Exception {

		pedidoDTO.setCodigoCliente(tokenService.getIdUsuarioPorHeader(token));

		return ResponseEntity.ok(pedidoService.adicionar(pedidoDTO));
	}

	@Override
	public ResponseEntity<PedidoDTO> adquirir(Long codigoPedido) {

		return ResponseEntity.ok(pedidoService.adquirirDTO(codigoPedido));
	}

	@Override
	public ResponseEntity<List<PedidoDTO>> adquirirNaoFinalizados(String token) {

		return ResponseEntity.ok(pedidoService.adquirirNaoFinalizados(tokenService.getIdUsuarioPorHeader(token)));
	}

	@Override
	public ResponseEntity<Void> atualizarStatus(Long codigoPedido, Long codigoStatus) throws Exception {

		pedidoService.atualizarStatus(codigoPedido, codigoStatus);

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Void> recusar(Long codigoPedido) throws Exception {

		pedidoService.recusar(codigoPedido);

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<ListagemPedidoDTO>> adquirirTodos(String token) {
		tokenService.getIdUsuarioPorHeader(token);

		return ResponseEntity.ok(pedidoService.adquirirTodos(tokenService.getIdUsuarioPorHeader(token)));
	}

}
