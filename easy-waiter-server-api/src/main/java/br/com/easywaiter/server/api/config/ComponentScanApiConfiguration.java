package br.com.easywaiter.server.api.config;

import javax.inject.Named;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Named("ComponentScanApi")
@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = { "br.com.easywaiter.server.service" }, lazyInit = true)
public class ComponentScanApiConfiguration {

}
