package com.goal.dao;

import com.goal.po.CmdSku;

public interface CmdSkuDAO {
    int insert(CmdSku record);

    int insertSelective(CmdSku record);
}