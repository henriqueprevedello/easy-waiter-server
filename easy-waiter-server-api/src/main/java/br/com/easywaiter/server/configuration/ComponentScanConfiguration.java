package br.com.easywaiter.server.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy(false)
@Configuration(proxyBeanMethods = false)
@ComponentScan(lazyInit = false, basePackages = { "br.com.easywaiter.server.api" })
public class ComponentScanConfiguration {

}
