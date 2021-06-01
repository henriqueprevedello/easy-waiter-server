package br.com.easywaiter.server.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ComponentScan(lazyInit = false, basePackages = { "br.com.easywaiter.server.repository.jpa",
		"br.com.easywaiter.server.repository" })
public class ComponentScanServiceConfiguration {

}
