package br.com.easywaiter.server.util.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItemDTO {

	private ProdutoDTO produto;

	private Long quantidade;

}
