package br.com.easywaiter.server.util.dto;

import java.util.ArrayList;
import java.util.List;

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

	private String chavePix;

	private List<ProdutoDTO> produtos = new ArrayList<>();

	private List<MesaDTO> mesas = new ArrayList<>();

}
