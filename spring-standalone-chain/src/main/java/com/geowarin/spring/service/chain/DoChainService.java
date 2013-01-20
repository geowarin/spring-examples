package com.geowarin.spring.service.chain;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Service;

import com.geowarin.spring.component.chain.ChainContext;
import com.geowarin.spring.component.chain.ChainElement;

@Service
@Qualifier("doChain")
public class DoChainService implements ChainService {
	
	@Autowired
	private List<ChainElement> chain;
	
	@PostConstruct
	public void init() {
		Collections.sort(chain, AnnotationAwareOrderComparator.INSTANCE);
	}

	@Override
	public void executeChain(ChainContext context) {

		for (ChainElement chainElement : chain) {
			if (chainElement.doChain(context))
				break;
		}
	}
}
