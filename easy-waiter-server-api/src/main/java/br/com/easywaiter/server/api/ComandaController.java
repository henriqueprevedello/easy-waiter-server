package br.com.easywaiter.server.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.easywaiter.server.util.dto.ComandaClienteDTO;
import br.com.easywaiter.server.util.dto.ComandaDTO;

@RequestMapping(value = "/comanda")
public interface ComandaController {

	@GetMapping(value = "/adquirirTodas")
	public ResponseEntity<List<ComandaDTO>> adquirirTodas(@RequestHeader(name = "Authorization") String token);

	@GetMapping
	public ResponseEntity<ComandaDTO> adquirir(@RequestParam(name = "codigoComanda") Long codigoComanda)
			throws Exception;

	@PostMapping(value = "/pagar")
	public ResponseEntity<Void> pagar(@RequestHeader(name = "Authorization") String token) throws Exception;

	@GetMapping(value = "/adquirirAberta")
	public ResponseEntity<ComandaClienteDTO> adquirirAberta(@RequestHeader(name = "Authorization") String token);

	@GetMapping(value = "/pagamentoRealizado")
	public ResponseEntity<Boolean> pagamentoRealizado(@RequestHeader(name = "Authorization") String token)
			throws Exception;

	@PutMapping
	public ResponseEntity<Void> confirmarPagamento(@RequestParam(name = "codigoComanda") Long codigoComanda)
			throws Exception;

}
