package br.com.easywaiter.server.util.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {

	private List<PedidoItemDTO> pedidoItens;

	private Long codigoCliente;

	private Long codigoEstabelecimento;

	private Long codigoMesa;

}
