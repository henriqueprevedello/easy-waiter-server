package br.com.easywaiter.server.util.modelMapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

public abstract class ConverterConfigurerSupport<S, D> implements ModelMapperConfigurer {

	public abstract Converter<S, D> converter();

	public void configure(ModelMapper modelMapper) {

		modelMapper.addConverter(converter());
	}
}
