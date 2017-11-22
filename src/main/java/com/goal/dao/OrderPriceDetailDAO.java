package com.goal.dao;

import com.goal.po.OrderPriceDetail;

public interface OrderPriceDetailDAO {
    int insert(OrderPriceDetail record);

    int insertSelective(OrderPriceDetail record);
}