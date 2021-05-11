package br.com.easywaiter.server.util.modelMapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelMapperFactoryBean implements FactoryBean<ModelMapper> {

	private static final Class<ModelMapper> MODEL_MAPPER_CLASS = ModelMapper.class;

	@Autowired(required = false)
	private List<ModelMapperConfigurer> configurers;

	@Override
	public ModelMapper getObject() throws Exception {

		final ModelMapper modelMapper = new ModelMapper();

		configure(modelMapper);
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		return modelMapper;
	}

	@Override
	public Class<?> getObjectType() {
		return MODEL_MAPPER_CLASS;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	private void configure(ModelMapper modelMapper) {
		if (configurers != null) {
			for (ModelMapperConfigurer modelMapperConfigurer : configurers) {
				modelMapperConfigurer.configure(modelMapper);
			}
		}
	}
}
