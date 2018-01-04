package com.goal.dao;

import com.goal.dto.OrderDTO;
import com.goal.po.Order;

public interface OrderDAO {
    int insert(Order record);

    int insertSelective(Order record);
    
    /**
     * 根据order id取得order
     * @param dto
     * @return
     */
    Order selectOrderById(String orderId);
}