package br.com.easywaiter.server.util.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {

	private Long id;

	private String nome;

	private List<ProdutoDTO> produtos = new ArrayList<>();

}
