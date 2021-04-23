package br.com.easywaiter.server.util.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComandaDTO {

	private Long id;

	private Long codigoMesa;

	private MesaDTO mesa;

	private ClienteDTO cliente;

	private BigDecimal valorTotal;

	private List<PedidoDTO> pedidos = new ArrayList<>();

	private String dataAbertura;

	private String dataFechamento;

	private String dataPagamento;
}
