package br.com.easywaiter.server.util.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

	private String email;
	
	private String senha;
	
	private String nome;
	
	private String token;
	
}
