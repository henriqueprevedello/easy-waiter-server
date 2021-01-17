package br.com.easywaiter.server.util.enumerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum StatusPedidoEnum {

	INICIADO(0L),

	RECUSADO(1L),

	CANCELADO(2L),

	EM_PREPARO(3L),

	ENTREGUE(4L);

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
}
