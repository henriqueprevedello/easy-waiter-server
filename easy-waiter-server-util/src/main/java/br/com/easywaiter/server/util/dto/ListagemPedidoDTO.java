package br.com.easywaiter.server.util.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListagemPedidoDTO {

	private Long id;

	private BigDecimal valorTotal;

	private Long quantidadeProdutos;

	private Long codigoStatus;

	private String dataCadastro;

}
