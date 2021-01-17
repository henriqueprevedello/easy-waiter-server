package br.com.easywaiter.server.util.dto;

import java.util.ArrayList;
import java.util.Date;
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

	private List<PedidoDTO> pedidos = new ArrayList<>();

	private Date dataAbertura;

	private Date dataFechamento;

}
