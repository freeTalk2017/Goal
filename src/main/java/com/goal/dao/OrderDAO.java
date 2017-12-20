package com.goal.dao;

import com.goal.po.Order;

public interface OrderDAO {
    int insert(Order record);

    int insertSelective(Order record);
}