package br.com.easywaiter.server.service.mapping;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import br.com.easywaiter.server.repository.domain.PedidoItem;
import br.com.easywaiter.server.util.dto.PedidoItemDTO;
import br.com.easywaiter.server.util.modelMapper.PropertyMapConfigurerSupport;

@Component
public class PedidoItemDTOToPedidoItemMapping extends PropertyMapConfigurerSupport<PedidoItemDTO, PedidoItem> {

	@Override
	public PropertyMap<PedidoItemDTO, PedidoItem> mapping() {
		return new PropertyMap<PedidoItemDTO, PedidoItem>() {

			@Override
			protected void configure() {
				map(source.getProduto().getId(), destination.getCodigoProduto());

			}
		};
	}

}
