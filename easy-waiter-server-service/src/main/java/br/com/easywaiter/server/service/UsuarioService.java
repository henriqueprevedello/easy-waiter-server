package br.com.easywaiter.server.service;

import br.com.easywaiter.server.util.dto.UsuarioDTO;

public interface UsuarioService {

	void registrarCliente(UsuarioDTO usuarioDTO);

	void editarNome(String nome, Long codigoUsuario) throws Exception;

}
