package com.goal.dao;

import com.goal.po.CmdSkuDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmdSkuDetailDAO {
    int insert(CmdSkuDetail record);

    int insertSelective(CmdSkuDetail record);

}