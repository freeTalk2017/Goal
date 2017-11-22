package com.goal.dao;

import com.goal.po.WxPayRecieve;

public interface WxPayRecieveDAO {
    int insert(WxPayRecieve record);

    int insertSelective(WxPayRecieve record);
}