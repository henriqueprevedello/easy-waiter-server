package br.com.easywaiter.server.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration(proxyBeanMethods = false)
@EnableJpaRepositories(basePackages = { "br.com.easywaiter.server.repository.jpa" })
@EntityScan(basePackages = { "br.com.easywaiter.server.repository.domain" })
public class ScanJPARepositoryConfiguration {

}
