package com.geowarin.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.geowarin.spring.MainBean;

@Configuration
@ComponentScan(basePackages = {"com.geowarin.spring.service", "com.geowarin.spring.component"})
@PropertySource(value = "classpath:chain.properties")
public class SpringStandalonChainConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
		pspc.setPlaceholderPrefix("#{");
		return pspc;
	}
	
	@Bean
	public MainBean mainBean() {
		return new MainBean();
	}
}
