package br.com.easywaiter.server.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.easywaiter.server.util.dto.ComandaDTO;

@RequestMapping(value = "/comanda")
public interface ComandaController {

	@GetMapping
	public ResponseEntity<List<ComandaDTO>> adquirir(@RequestHeader(name = "Authorization") String token);

}
