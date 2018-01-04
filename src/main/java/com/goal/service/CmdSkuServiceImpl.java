package com.goal.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goal.dao.CmdSkuDAO;
import com.goal.dto.SkuDTO;
import com.goal.dto.SkuDetailDTO;
import com.goal.dto.SkuQueryResultDTO;

/**
 * 
 * @author lizhiwei
 *
 */
@Component("skuService")
public class CmdSkuServiceImpl implements CmdSkuService {

	@Autowired
	private CmdSkuDAO cmdSkuDAO;
	
	@Override
	/**
	 * 根据商品id取得单品信息
	 */
	public List<SkuDTO> getSkuListByCmdId(SkuDTO skuDTO) {
		List<SkuQueryResultDTO> resultSet = cmdSkuDAO.selectSkuListByCmdId(skuDTO.getCmdId());
		return transformDTO(resultSet);
	}

	/**
	 * 从数据库结果集转换为输出list
	 * @param skuQueryResultList
	 * @return
	 */
	private List<SkuDTO> transformDTO(List<SkuQueryResultDTO> skuQueryResultList){
		List<SkuDTO> result = null;
		if(skuQueryResultList!=null && skuQueryResultList.size()>0) {
			result = new ArrayList<>();
		}
		//先装入单品dto
		Set<String> skuIdSet = new HashSet<>();
		for (SkuQueryResultDTO sqrDTO : skuQueryResultList) {
			if(sqrDTO.getpId()!=null) {
				continue;//只取得父属性
			}
			if(!skuIdSet.contains(sqrDTO.getSkuId())) {//保存sku并去重
				SkuDTO skuDTO = new SkuDTO();
				skuDTO.setId(sqrDTO.getSkuId());
				skuDTO.setPrice(sqrDTO.getPrice());
				skuDTO.setStock(99);//mock stock, need to be updated
				//解析属性
				List<SkuDetailDTO> skuDetailDTOList = new ArrayList<>();
				for(SkuQueryResultDTO innerSqrDTO : skuQueryResultList) {
					if(sqrDTO.getSkuDetailId().equals(innerSqrDTO.getpId())) {
						SkuDetailDTO skuDetailDTO = new SkuDetailDTO();
						skuDetailDTO.setId(innerSqrDTO.getSkuDetailId());
						skuDetailDTO.setIndex(innerSqrDTO.getIndex());
						skuDetailDTO.setParamKey(innerSqrDTO.getParamKey());
						skuDetailDTO.setParamValue(innerSqrDTO.getParamValue());
						skuDetailDTOList.add(skuDetailDTO);
						//to be continue....
					}
				}
				result.add(skuDTO);
				skuIdSet.add(sqrDTO.getSkuId());//把skuId加入set中
			}
		}
		//包装属性
		for(SkuDTO skuDto : result) {
			
		}
		return result;
	}
}
