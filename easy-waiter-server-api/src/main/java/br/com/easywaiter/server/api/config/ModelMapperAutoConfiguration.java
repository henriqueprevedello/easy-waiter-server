package br.com.easywaiter.server.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import br.com.easywaiter.server.util.modelMapper.ModelMapperFactoryBean;

@Lazy(false)
@Configuration(proxyBeanMethods = false)
public class ModelMapperAutoConfiguration {

	@Bean
	public ModelMapperFactoryBean modelMapperFactoryBean() {

		return new ModelMapperFactoryBean();
	}
}
