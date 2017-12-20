package com.goal.dao;

import com.goal.po.TmpUser;

public interface TmpUserDAO {
    int insert(TmpUser record);

    int insertSelective(TmpUser record);
}