package com.goal.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goal.dto.SkuDTO;
import com.goal.service.CmdSkuService;

@Component("skuControllerHelper")
/**
 * 单品controller helper
 * @author lizhiwei
 *
 */
public class CmdSkuControllerHelper extends GenericControllerHelper{
	
	@Autowired
	private CmdSkuService skuService;
	/**
	 * 通过商品id取得单品集合
	 * @param cmdId
	 * @return
	 */
	public List<SkuDTO> getSkuListByCmdId(SkuDTO skuDTO){
		return skuService.getSkuListByCmdId(skuDTO);
	}
}
