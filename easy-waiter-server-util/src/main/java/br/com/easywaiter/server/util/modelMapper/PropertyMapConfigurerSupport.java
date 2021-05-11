package br.com.easywaiter.server.util.modelMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public abstract class PropertyMapConfigurerSupport<S, D> implements ModelMapperConfigurer {

	public abstract PropertyMap<S, D> mapping();

	@Override
	public void configure(ModelMapper modelMapper) {

		modelMapper.addMappings(mapping());
	}
}
