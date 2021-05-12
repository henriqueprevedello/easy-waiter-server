package br.com.easywaiter.server.api.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class ModelMapperConfigure {

	public void configure(ModelMapper modelMapper) {
		modelMapper.getConfiguration().setMethodAccessLevel(AccessLevel.PUBLIC).setFieldMatchingEnabled(Boolean.TRUE)
				.setMatchingStrategy(MatchingStrategies.STRICT);
	}
}
