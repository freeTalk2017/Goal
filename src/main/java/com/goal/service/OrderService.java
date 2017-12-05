package com.goal.service;

import com.goal.dto.OrderDTO;

/**
 * 订单服务接口
 * @author lizhiwei
 *
 */
public interface OrderService {
	/**
	 * 提交订单
	 * @param dto
	 * @return 订单详情
	 */
	OrderDTO submitOrder(OrderDTO dto);
}
