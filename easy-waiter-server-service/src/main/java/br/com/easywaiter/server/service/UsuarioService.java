package br.com.easywaiter.server.service;

import br.com.easywaiter.server.util.dto.UsuarioDTO;

public interface UsuarioService {
	
	void login(String email, String senha);
	
	void registrar(UsuarioDTO usuarioDTO);

}
