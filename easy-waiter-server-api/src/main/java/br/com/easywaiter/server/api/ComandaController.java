package br.com.easywaiter.server.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.easywaiter.server.util.dto.ComandaDTO;

@RequestMapping(value = "/comanda")
public interface ComandaController {

	@GetMapping(value = "/adquirirTodas")
	public ResponseEntity<List<ComandaDTO>> adquirirTodas(@RequestHeader(name = "Authorization") String token);

	@GetMapping
	public ResponseEntity<ComandaDTO> adquirir(@RequestParam(name = "codigoComanda") Long codigoComanda)
			throws Exception;

}
