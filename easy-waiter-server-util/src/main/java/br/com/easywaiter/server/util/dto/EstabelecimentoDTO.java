package br.com.easywaiter.server.util.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstabelecimentoDTO {

	private Long codigoEstabelecimento;

	private String nome;

	private String descricao;

	private String numeroTelefone;

	private String cnpj;

	private String estado;

	private String cidade;

}
