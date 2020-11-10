package br.com.easywaiter.server.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.easywaiter.server.util.dto.EstabelecimentoDTO;
import br.com.easywaiter.server.util.dto.LocalizacaoDTO;

@RequestMapping(value = "/estabelecimento")
public interface EstabelecimentoController {

	@PostMapping
	public ResponseEntity<EstabelecimentoDTO> editar(@RequestBody EstabelecimentoDTO estabelecimentoDTO)
			throws Exception;

	@GetMapping
	public ResponseEntity<EstabelecimentoDTO> adquirir(@RequestHeader(name = "Authorization") String token);

	@GetMapping(path = "/adquirirLocalizacoes")
	public ResponseEntity<List<LocalizacaoDTO>> adquirirLocalizacoes();

	@GetMapping(path = "/adquirirPorLocalizacao")
	public ResponseEntity<List<EstabelecimentoDTO>> adquirirPorLocalizacao(@RequestParam(name = "cidade") String cidade,
			@RequestParam(name = "estado") String estado);

}
