package com.goal.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goal.dao.OrderDAO;
import com.goal.dto.OrderDTO;

/**
 * 订单服务实现类
 * @author lizhiwei
 *
 */
@Component
public class OrderServiceImpl implements OrderService{

	@Resource
	private OrderDAO orderDao;
	@Override
	/**
	 * 提交订单
	 */
	public OrderDTO submitOrder(OrderDTO dto) {
		return null;
	}

}
