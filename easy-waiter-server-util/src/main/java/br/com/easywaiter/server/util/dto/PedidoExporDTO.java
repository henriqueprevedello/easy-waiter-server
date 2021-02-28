package br.com.easywaiter.server.util.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoExporDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private List<PedidoItemDTO> pedidoItens;

	private String nomeCliente;

	private MesaDTO mesaDTO;

	private Long codigoStatus;

	private String dataCadastro;

}
