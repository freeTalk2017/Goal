package com.goal.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goal.dto.SkuDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class CmdSkuServiceTest {
	@Autowired
	private CmdSkuService skuService;
	
	@Test
	public void testSelectSkuListByCmdId() {
		SkuDTO dto = new SkuDTO();
		dto.setCmdId("1234");
		List<SkuDTO> skuDTOList = skuService.getSkuListByCmdId(dto);
		for (SkuDTO skuDTO : skuDTOList) {
			System.out.println(skuDTO);
		}
	}
	
	@Test
	public void testToString() {
		SkuDTO dto = new SkuDTO();
		dto.setPrice(22);
		dto.setStock(99);
		System.out.println(dto);
	}
}
