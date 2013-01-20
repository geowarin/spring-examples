package com.geowarin.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringStandaloneChainApp {
	
	private static final String CONFIG_PACKAGE = "com.geowarin.spring.config";

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
			
			ctx.scan(CONFIG_PACKAGE);
			ctx.refresh();		
			
			MainBean bean = ctx.getBean(MainBean.class);
			bean.start();		
		}
	}
}
