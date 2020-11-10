package br.com.easywaiter.server.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.MesaController;
import br.com.easywaiter.server.configuration.TokenService;
import br.com.easywaiter.server.service.MesaService;
import br.com.easywaiter.server.util.dto.MesaDTO;

@RestController
public class MesaControllerImpl implements MesaController {

	@Autowired
	private MesaService mesaService;

	@Autowired
	private TokenService tokenService;

	@Override
	public ResponseEntity<Void> cadastrar(List<Long> listaMesas, String token) {

		mesaService.cadastrar(listaMesas, tokenService.getIdUsuarioPorHeader(token));

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<MesaDTO>> adquirirPorEstabelecimento(String token) {

		return ResponseEntity.ok(mesaService.adquirirPorEstabelecimento(tokenService.getIdUsuarioPorHeader(token)));
	}

}
