package br.com.easywaiter.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import br.com.easywaiter.server.service.config.ArmazenamentoArquivoProperties;

@SpringBootApplication(scanBasePackages = { "br.com.easywaiter.server.configuration", "br.com.easywaiter.server.api",
		"br.com.easywaiter.server.service" })
@PropertySource(ignoreResourceNotFound = false, value = "classpath:application.properties")
@EnableConfigurationProperties({ ArmazenamentoArquivoProperties.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
