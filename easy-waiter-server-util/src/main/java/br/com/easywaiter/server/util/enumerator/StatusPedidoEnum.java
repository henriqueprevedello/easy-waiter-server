package br.com.easywaiter.server.util.enumerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public enum StatusPedidoEnum {

	CANCELADO(0L),

	RECUSADO(1L),

	REALIZADO(2L),

	CONFIRMADO(3L),

	EM_PREPARO(4L),

	EM_ENTREGA(5L),

	ENTREGUE(6L);

	private static Map<Long, StatusPedidoEnum> mapa = new HashMap<>();

	static {

		for (StatusPedidoEnum enumerador : StatusPedidoEnum.values()) {

			mapa.put(enumerador.getCodigo(), enumerador);
		}
	}

	private Long codigo;

	StatusPedidoEnum(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public static StatusPedidoEnum getEnum(Long codigo) {

		Optional<StatusPedidoEnum> optionalTipoValorAcrescimoDescontoEnum = Optional.ofNullable(mapa.get(codigo));

		if (optionalTipoValorAcrescimoDescontoEnum.isPresent()) {

			return optionalTipoValorAcrescimoDescontoEnum.get();
		}

		return StatusPedidoEnum.CANCELADO;
	}

	public static List<StatusPedidoEnum> getFinalizados() {

		return Arrays.asList(StatusPedidoEnum.CANCELADO, StatusPedidoEnum.RECUSADO, StatusPedidoEnum.ENTREGUE);

	}
}
