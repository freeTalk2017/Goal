package com.goal.dao;

import java.util.List;

import com.goal.dto.SkuQueryResultDTO;
import com.goal.po.CmdSku;

public interface CmdSkuDAO {
    int insert(CmdSku record);

    int insertSelective(CmdSku record);
    
    List<SkuQueryResultDTO> selectSkuListByCmdId(String cmdId);
}