package br.com.easywaiter.server.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.easywaiter.server.util.dto.ListagemPedidoDTO;
import br.com.easywaiter.server.util.dto.PedidoDTO;

@RequestMapping(value = "/pedido")
public interface PedidoController {

	@PostMapping
	public ResponseEntity<Long> adicionar(@RequestBody PedidoDTO pedidoDTO,
			@RequestHeader(name = "Authorization") String token) throws Exception;

	@GetMapping
	public ResponseEntity<PedidoDTO> adquirir(@RequestParam(name = "codigoPedido") Long codigoPedido);

	@GetMapping("/adquirirNaoFinalizados")
	public ResponseEntity<List<PedidoDTO>> adquirirNaoFinalizados(@RequestHeader(name = "Authorization") String token);

	@PostMapping("/atualizarStatus")
	public ResponseEntity<Void> atualizarStatus(@RequestParam(name = "codigoPedido") Long codigoPedido,
			@RequestParam(name = "codigoStatus") Long codigoStatus) throws Exception;

	@PostMapping("/recusar")
	public ResponseEntity<Void> recusar(@RequestParam(name = "codigoPedido") Long codigoPedido) throws Exception;

	@GetMapping("/adquirirTodos")
	public ResponseEntity<List<ListagemPedidoDTO>> adquirirTodos(@RequestHeader(name = "Authorization") String token);

}
