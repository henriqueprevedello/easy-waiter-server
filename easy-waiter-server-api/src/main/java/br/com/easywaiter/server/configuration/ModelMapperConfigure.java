package br.com.easywaiter.server.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.easywaiter.server.util.modelMapper.ModelMapperConfigurer;

@Lazy
@Component
public class ModelMapperConfigure implements ModelMapperConfigurer {

	@Override
	public void configure(ModelMapper modelMapper) {
		modelMapper.getConfiguration().setMethodAccessLevel(AccessLevel.PUBLIC).setFieldMatchingEnabled(Boolean.TRUE)
				.setMatchingStrategy(MatchingStrategies.STRICT);
	}
}
