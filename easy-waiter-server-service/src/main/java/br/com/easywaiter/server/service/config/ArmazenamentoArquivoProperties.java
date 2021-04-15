package br.com.easywaiter.server.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "arquivo")
public class ArmazenamentoArquivoProperties {

	private String diretorioUploads;

}
