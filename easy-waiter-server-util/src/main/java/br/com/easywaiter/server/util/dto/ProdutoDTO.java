package br.com.easywaiter.server.util.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

	private Long id;

	private String nome;

	private String descricao;

	private BigDecimal valor;

	private Boolean ativo;

	private CategoriaDTO categoria;

	private String nomeImagem;

}
