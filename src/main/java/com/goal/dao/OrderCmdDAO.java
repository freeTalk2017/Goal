package com.goal.dao;

import com.goal.po.OrderCmd;

public interface OrderCmdDAO {
    int insert(OrderCmd record);

    int insertSelective(OrderCmd record);
}