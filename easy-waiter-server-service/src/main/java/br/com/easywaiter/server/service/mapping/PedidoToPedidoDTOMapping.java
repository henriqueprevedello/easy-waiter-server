package br.com.easywaiter.server.service.mapping;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import br.com.easywaiter.server.repository.domain.Pedido;
import br.com.easywaiter.server.util.dto.PedidoDTO;
import br.com.easywaiter.server.util.modelMapper.PropertyMapConfigurerSupport;

@Component
public class PedidoToPedidoDTOMapping extends PropertyMapConfigurerSupport<Pedido, PedidoDTO> {

	@Override
	public PropertyMap<Pedido, PedidoDTO> mapping() {
		return new PropertyMap<Pedido, PedidoDTO>() {

			@Override
			protected void configure() {
				map(source.getComanda().getCliente().getUsuario().getNome(), destination.getNomeCliente());
				map(source.getComanda().getMesa().getNumero(), destination.getNumeroMesa());
				map(source.getComanda().getMesa().getId(), destination.getCodigoMesa());

			}
		};
	}

}
