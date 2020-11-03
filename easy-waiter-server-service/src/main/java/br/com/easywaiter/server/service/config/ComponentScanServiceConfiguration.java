package br.com.easywaiter.server.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("ComponentScanService")
@ComponentScan(lazyInit = true, basePackages = { "br.com.easywaiter.server.repository.jpa" })
public class ComponentScanServiceConfiguration {

}
