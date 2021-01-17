package br.com.easywaiter.server.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = { "br.com.easywaiter.server.service" }, lazyInit = true)
public class ComponentScanApiConfiguration {

}
