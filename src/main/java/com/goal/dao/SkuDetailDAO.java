package com.goal.dao;

import com.goal.po.SkuDetail;

public interface SkuDetailDAO {
    int insert(SkuDetail record);

    int insertSelective(SkuDetail record);
}