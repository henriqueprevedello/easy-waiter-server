package br.com.easywaiter.server.service.mapping;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import br.com.easywaiter.server.repository.domain.Estabelecimento;
import br.com.easywaiter.server.util.dto.EstabelecimentoDTO;
import br.com.easywaiter.server.util.modelMapper.PropertyMapConfigurerSupport;

@Component
public class EstabelecimentoToEstabelecimentoDTOMapping
		extends PropertyMapConfigurerSupport<Estabelecimento, EstabelecimentoDTO> {

	@Override
	public PropertyMap<Estabelecimento, EstabelecimentoDTO> mapping() {
		return new PropertyMap<Estabelecimento, EstabelecimentoDTO>() {

			@Override
			protected void configure() {
				map(source.getUsuario().getNome(), destination.getNome());

			}
		};
	}

}
