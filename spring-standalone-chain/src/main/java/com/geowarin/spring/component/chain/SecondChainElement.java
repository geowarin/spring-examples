package com.geowarin.spring.component.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SecondChainElement implements ChainElement {
	
	private static Logger log = LoggerFactory.getLogger(SecondChainElement.class);

	@Override
	public boolean doChain(ChainContext context) {
		
		if (context.isCompatibleWithSecondElement()) {
			log.info("Handled by second");
			context.setHandledBySecond(true);
			return true;
		}
		
		return false;
	}
}
