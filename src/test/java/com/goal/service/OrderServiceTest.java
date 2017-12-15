package com.goal.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goal.dto.OrderAddressDTO;
import com.goal.dto.OrderCmdDTO;
import com.goal.dto.OrderDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class OrderServiceTest {
	private OrderDTO orderDTO;
	
	@Autowired
	private OrderService orderService;
	@Before
	public void dataPrepare() {
		System.out.println("preparing data..");
		orderDTO = new OrderDTO();
		orderDTO.setUserId("123");
		orderDTO.setDeliveryWay("1");
		//设置订单商品
		List<OrderCmdDTO> ocList = new ArrayList<>();
		OrderCmdDTO ocDTO = new OrderCmdDTO();
		ocDTO.setCmdCount("1");
		ocDTO.setCmdId("1234");
		ocDTO.setCmdSkuId("123");
		ocDTO.setCmdCount("2");
		ocDTO.setSkuPrice("1100");
		ocList.add(ocDTO);
		orderDTO.setOrderCmdList(ocList);
		//设置订单地址
		OrderAddressDTO oaDTO = new OrderAddressDTO();
		oaDTO.setReceiver("测试用户1");
		oaDTO.setTelephone("13800138000");
		oaDTO.setProvince("四川省");
		oaDTO.setCity("成都市");
		oaDTO.setStreet("天府三街");
		oaDTO.setZipCode("610000");
		orderDTO.setOrderAddress(oaDTO);
	}
	
	@Test
	public void testOrderSubmit() {
		System.out.println("start to submit order..");
		try {
			orderService.submitOrder(orderDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
