package com.goal.service;

import java.util.List;

import com.goal.dto.SkuDTO;

/**
 * 单品service
 * @author lizhiwei
 *
 */
public interface CmdSkuService {
	/**
	 * 根据商品id取得单品信息
	 */
	List<SkuDTO> getSkuListByCmdId(SkuDTO skuDTO);
}
