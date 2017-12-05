package com.goal.helper;

import org.springframework.stereotype.Component;

import com.goal.dto.OrderDTO;

@Component("orderHelper")
public class OrderControllerHelper extends GenericControllerHelper{
	
	/**
	 * 提交订单
	 * @param dto
	 * @return 订单关键字段
	 */
	public OrderDTO submitOrder(OrderDTO dto) {
		return null;
	}
}
