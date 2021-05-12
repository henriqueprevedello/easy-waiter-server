package br.com.easywaiter.server.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration(proxyBeanMethods = false)
@ComponentScan(lazyInit = false, basePackages = { "br.com.easywaiter.server.service" })
public class ComponentScanApiConfiguration {

}
