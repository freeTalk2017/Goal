package com.goal.dao;

import com.goal.po.OrderAddress;

public interface OrderAddressDAO {
    int insert(OrderAddress record);

    int insertSelective(OrderAddress record);
}