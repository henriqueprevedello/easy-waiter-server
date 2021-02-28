package br.com.easywaiter.server.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.easywaiter.server.util.dto.MesaDTO;

@RequestMapping(value = "/mesa")
public interface MesaController {

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestParam(name = "numeroMesa") Long numeroMesa,
			@RequestHeader(name = "Authorization") String token) throws Exception;

	@GetMapping
	public ResponseEntity<List<MesaDTO>> adquirirPorEstabelecimento(
			@RequestHeader(name = "Authorization") String token);

	@PutMapping
	public ResponseEntity<Void> editar(@RequestBody MesaDTO mesaDTO) throws Exception;

	@DeleteMapping
	public ResponseEntity<Void> excluir(@RequestParam(value = "codigoMesa") Long codigoMesa) throws Exception;

}
