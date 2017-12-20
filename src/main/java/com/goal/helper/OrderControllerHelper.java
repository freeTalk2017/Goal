package com.goal.helper;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.goal.dto.OrderDTO;
import com.goal.dto.ResponseOrderDTO;
import com.goal.service.OrderService;

@Component("orderHelper")
public class OrderControllerHelper extends GenericControllerHelper{
	
	@Resource
	private OrderService orderService;
	/**
	 * 提交订单
	 * @param dto
	 * @return 订单关键字段
	 * @throws Exception 
	 */
	public ResponseOrderDTO submitOrder(OrderDTO dto) throws Exception {
		return orderService.submitOrder(dto);
	}
}
