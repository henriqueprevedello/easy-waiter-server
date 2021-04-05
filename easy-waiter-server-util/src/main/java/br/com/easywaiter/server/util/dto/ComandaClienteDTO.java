package br.com.easywaiter.server.util.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComandaClienteDTO {

	private Long id;

	private Long numeroMesa;

	private String nomeEstabelecimento;

	private String nomeCliente;

	private List<PedidoDTO> pedidos = new ArrayList<>();

	private String dataAbertura;

	private String dataFechamento;

	private BigDecimal valorTotal;

}
