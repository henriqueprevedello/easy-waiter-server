package br.com.easywaiter.server.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.ComandaController;
import br.com.easywaiter.server.api.config.TokenService;
import br.com.easywaiter.server.service.ComandaService;
import br.com.easywaiter.server.util.dto.ComandaClienteDTO;
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

	@Override
	public ResponseEntity<Void> pagar(String token) throws Exception {

		comandaService.pagar(tokenService.getIdUsuarioPorHeader(token));

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<ComandaClienteDTO> adquirirAberta(String token) {

		return ResponseEntity.ok(comandaService.adquirirAberta(tokenService.getIdUsuarioPorHeader(token)));
	}

	@Override
	public ResponseEntity<Boolean> pagamentoRealizado(String token) throws Exception {

		return ResponseEntity.ok(comandaService.verificarPagamento(tokenService.getIdUsuarioPorHeader(token)));
	}

	@Override
	public ResponseEntity<Void> confirmarPagamento(Long codigoComanda) throws Exception {

		comandaService.confirmarPagamento(codigoComanda);

		return ResponseEntity.ok().build();
	}

}
