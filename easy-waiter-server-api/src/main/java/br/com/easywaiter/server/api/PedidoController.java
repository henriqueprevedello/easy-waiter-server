package br.com.easywaiter.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.easywaiter.server.util.dto.PedidoDTO;

@RequestMapping(value = "/pedido")
public interface PedidoController {

	@PostMapping
	public ResponseEntity<Void> adicionar(@RequestBody PedidoDTO pedidoDTO,
			@RequestHeader(name = "Authorization") String token);

}
