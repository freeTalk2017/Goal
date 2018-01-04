package com.goal.dao;

import com.goal.po.CmdSkuHasSkuDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmdSkuHasSkuDetailDAO {
    int insert(CmdSkuHasSkuDetail record);

    int insertSelective(CmdSkuHasSkuDetail record);

}