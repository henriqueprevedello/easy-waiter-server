package br.com.easywaiter.server.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.EstabelecimentoController;
import br.com.easywaiter.server.configuration.TokenService;
import br.com.easywaiter.server.service.EstabelecimentoService;
import br.com.easywaiter.server.util.dto.EstabelecimentoDTO;
import br.com.easywaiter.server.util.dto.LocalizacaoDTO;

@RestController
public class EstabelecimentoControllerImpl implements EstabelecimentoController {

	@Autowired
	private EstabelecimentoService estabelecimentoService;

	@Autowired
	private TokenService tokenService;

	@Override
	public ResponseEntity<EstabelecimentoDTO> editar(EstabelecimentoDTO estabelecimentoDTO) throws Exception {

		return ResponseEntity.ok(estabelecimentoService.editar(estabelecimentoDTO));
	}

	@Override
	public ResponseEntity<EstabelecimentoDTO> adquirir(String token) {

		return ResponseEntity.ok(estabelecimentoService.adquirir(tokenService.getIdUsuarioPorHeader(token)));
	}

	@Override
	public ResponseEntity<EstabelecimentoDTO> adquirirPorCodigo(Long codigoEstabelecimento) {

		return ResponseEntity.ok(estabelecimentoService.adquirir(codigoEstabelecimento));
	}

	@Override
	public ResponseEntity<List<LocalizacaoDTO>> adquirirLocalizacoes() {

		return ResponseEntity.ok(estabelecimentoService.adquirirLocalizacoes());
	}

	@Override
	public ResponseEntity<List<EstabelecimentoDTO>> adquirirPorLocalizacao(String cidade, String estado) {

		return ResponseEntity.ok(estabelecimentoService.adquirirPorLocalizacao(cidade, estado));
	}

}
