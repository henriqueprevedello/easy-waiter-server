package br.com.easywaiter.server.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.easywaiter.server.util.dto.PedidoDTO;
import br.com.easywaiter.server.util.dto.PedidoExporDTO;

@RequestMapping(value = "/pedido")
public interface PedidoController {

	@PostMapping
	public ResponseEntity<Long> adicionar(@RequestBody PedidoDTO pedidoDTO,
			@RequestHeader(name = "Authorization") String token);

	@GetMapping
	public ResponseEntity<PedidoDTO> adquirir(@RequestParam(name = "codigoPedido") Long codigoPedido);

	@GetMapping("/adquirirNaoFinalizados")
	public ResponseEntity<List<PedidoExporDTO>> adquirirNaoFinalizados(
			@RequestHeader(name = "Authorization") String token);

	@PostMapping("/prosseguir")
	public ResponseEntity<Void> prosseguir(@RequestParam(name = "codigoPedido") Long codigoPedido) throws Exception;

	@PostMapping("/recusar")
	public ResponseEntity<Void> recusar(@RequestParam(name = "codigoPedido") Long codigoPedido) throws Exception;

}
