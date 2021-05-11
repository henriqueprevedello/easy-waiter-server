package br.com.easywaiter.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import br.com.easywaiter.server.service.config.ArmazenamentoArquivoProperties;

@SpringBootApplication
@PropertySource(value = { "classpath:application.properties" })
@EnableConfigurationProperties({ ArmazenamentoArquivoProperties.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
