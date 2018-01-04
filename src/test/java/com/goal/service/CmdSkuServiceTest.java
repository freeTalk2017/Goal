package com.goal.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class CmdSkuServiceTest {
	@Autowired
	private CmdSkuService skuService;
	
	@Test
	public void testSelectSkuListByCmdId() {
		
	}
}
