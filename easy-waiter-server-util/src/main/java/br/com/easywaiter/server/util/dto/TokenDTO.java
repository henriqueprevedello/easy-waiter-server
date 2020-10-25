package br.com.easywaiter.server.util.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenDTO {
	
	String token;
	
	String tipo;

}
