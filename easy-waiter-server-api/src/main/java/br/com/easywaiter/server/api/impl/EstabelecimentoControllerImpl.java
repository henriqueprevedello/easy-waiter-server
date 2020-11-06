package br.com.easywaiter.server.api.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.easywaiter.server.api.EstabelecimentoController;
import br.com.easywaiter.server.util.dto.EstabelecimentoDTO;
import br.com.easywaiter.server.util.dto.LocalizacaoDTO;

@RestController
public class EstabelecimentoControllerImpl implements EstabelecimentoController {

	@Override
	public ResponseEntity<List<LocalizacaoDTO>> adquirirLocalizacoes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<EstabelecimentoDTO>> adquirirPorLocalizacao(String cidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
