package br.com.easywaiter.server.service.mapping;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import br.com.easywaiter.server.repository.domain.Pedido;
import br.com.easywaiter.server.util.dto.PedidoExporDTO;
import br.com.easywaiter.server.util.modelMapper.PropertyMapConfigurerSupport;

@Component
public class PedidoToPedidoExporDTOMapping extends PropertyMapConfigurerSupport<Pedido, PedidoExporDTO> {

	@Override
	public PropertyMap<Pedido, PedidoExporDTO> mapping() {
		return new PropertyMap<Pedido, PedidoExporDTO>() {

			@Override
			protected void configure() {
				map(source.getComanda().getCliente().getUsuario().getNome(), destination.getNomeCliente());
				map(source.getComanda().getMesa(), destination.getMesaDTO());

			}
		};
	}

}
