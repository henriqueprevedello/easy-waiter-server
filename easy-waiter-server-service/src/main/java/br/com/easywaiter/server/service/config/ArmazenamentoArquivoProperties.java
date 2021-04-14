package br.com.easywaiter.server.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "arquivo")
public class ArmazenamentoArquivoProperties {

	private String diretorioUploads;

}
