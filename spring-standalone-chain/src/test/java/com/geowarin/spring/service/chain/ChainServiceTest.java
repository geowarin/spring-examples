package com.geowarin.spring.service.chain;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geowarin.spring.component.chain.ChainContext;
import com.geowarin.spring.config.SpringStandalonChainConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringStandalonChainConfig.class })
public class ChainServiceTest extends TestCase {
	
	@Autowired
	private ChainService chainService;
	
	@Test
	public void testHandledByFirst() {
		
		ChainContext chainContext = new ChainContext(true, false);
		chainService.executeChain(chainContext);
		
		Assert.assertTrue(chainContext.isHandledByFirst());
		Assert.assertFalse(chainContext.isHandledBySecond());
	}
	
	@Test
	public void testHandledBySecond() {
		
		ChainContext chainContext = new ChainContext(false, true);
		chainService.executeChain(chainContext);
		
		Assert.assertFalse(chainContext.isHandledByFirst());
		Assert.assertTrue(chainContext.isHandledBySecond());
	}
}
