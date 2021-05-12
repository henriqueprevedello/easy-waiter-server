package br.com.easywaiter.server.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.MesaController;
import br.com.easywaiter.server.api.config.TokenService;
import br.com.easywaiter.server.service.MesaService;
import br.com.easywaiter.server.util.dto.MesaDTO;

@RestController
public class MesaControllerImpl implements MesaController {

	@Autowired
	private MesaService mesaService;

	@Autowired
	private TokenService tokenService;

	@Override
	public ResponseEntity<Void> cadastrar(Long numeroMesa, String token) throws Exception {

		mesaService.cadastrar(numeroMesa, tokenService.getIdUsuarioPorHeader(token));

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<MesaDTO>> adquirirPorEstabelecimento(String token) {

		return ResponseEntity.ok(mesaService.adquirirPorEstabelecimento(tokenService.getIdUsuarioPorHeader(token)));
	}

	@Override
	public ResponseEntity<Void> editar(MesaDTO mesaDTO) throws Exception {

		mesaService.editar(mesaDTO);

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Void> excluir(Long codigoMesa) throws Exception {

		mesaService.excluir(codigoMesa);

		return ResponseEntity.ok().build();
	}

}
