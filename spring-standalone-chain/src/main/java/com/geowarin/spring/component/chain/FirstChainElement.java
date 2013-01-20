package com.geowarin.spring.component.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class FirstChainElement implements ChainElement {
	
	private static Logger log = LoggerFactory.getLogger(FirstChainElement.class);

	@Override
	public boolean doChain(ChainContext context) {
		
		if (context.isCompatibleWithFirstElement()) {
			log.info("Handled by first");
			context.setHandledByFirst(true);
			return true;
		}
		
		return false;
	}
}
