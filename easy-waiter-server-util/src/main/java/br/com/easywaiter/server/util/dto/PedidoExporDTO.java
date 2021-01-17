package br.com.easywaiter.server.util.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoExporDTO {

	private Long id;

	private List<PedidoItemDTO> pedidoItens;

	private String nomeCliente;

	private MesaDTO mesaDTO;

	private Long codigoStatus;

	private Date dataCadastro;

}
