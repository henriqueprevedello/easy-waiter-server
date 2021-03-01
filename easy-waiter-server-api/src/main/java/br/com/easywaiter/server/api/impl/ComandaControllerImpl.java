package br.com.easywaiter.server.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.ComandaController;
import br.com.easywaiter.server.configuration.TokenService;
import br.com.easywaiter.server.service.ComandaService;
import br.com.easywaiter.server.util.dto.ComandaDTO;

@RestController
public class ComandaControllerImpl implements ComandaController {

	@Autowired
	private ComandaService comandaService;

	@Autowired
	private TokenService tokenService;

	@Override
	public ResponseEntity<List<ComandaDTO>> adquirirTodas(String token) {

		return ResponseEntity.ok(comandaService.adquirirTodas(tokenService.getIdUsuarioPorHeader(token)));
	}

	@Override
	public ResponseEntity<ComandaDTO> adquirir(Long codigoComanda) throws Exception {

		return ResponseEntity.ok(comandaService.adquirir(codigoComanda));
	}

}
