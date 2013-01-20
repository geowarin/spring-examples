package com.geowarin.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import com.geowarin.spring.component.chain.ChainContext;
import com.geowarin.spring.service.chain.ChainService;

public class MainBean {

	@Autowired
	@Qualifier("doChain")
	private ChainService service;
	
	@Value("#{chain.compatibleWithFirst}") boolean compatibleWithFirst;
	@Value("#{chain.compatibleWithSecond}") boolean compatibleWithSecond;
	
	private static Logger log = LoggerFactory.getLogger(MainBean.class);
	
	public void start() {
		
		log.info("property compatibleWithFirst=" + compatibleWithFirst);
		log.info("property compatibleWithSecond=" + compatibleWithSecond);
		
		ChainContext chainContext = new ChainContext(compatibleWithFirst, compatibleWithSecond);
		service.executeChain(chainContext);
	}
	
}
