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
			result = new ArrayList<>();//如果查询结果不为空，new ArrayList
		}
		//先装入单品dto
		Set<String> skuIdSet = new HashSet<>();
		/**
		 * 1.迭代查询结果集合，去重并保存单品sku集合
		 * 2.根据属性父id取得子属性集合
		 * 3.根据skuId，迭代查询结果集合，查找所有父属性并存入集合
		 * 
		 */
		
		for (SkuQueryResultDTO sqrDTO : skuQueryResultList) {
			if(sqrDTO.getpId()!=null) {
				continue;//只取得父属性
			}
			//1.保存sku并去重
			if(!skuIdSet.contains(sqrDTO.getSkuId())) {
				SkuDTO skuDTO = new SkuDTO();
				skuDTO.setId(sqrDTO.getSkuId());
				skuDTO.setPrice(sqrDTO.getPrice());
				skuDTO.setStock(99);//mock stock, need to be updated
				//解析属性
				List<SkuDetailDTO> skuDetailDTOList = new ArrayList<>();
				for(SkuQueryResultDTO innerSqrDTO : skuQueryResultList) {
					//如果skuId相同并且是父属性
					if( (sqrDTO.getSkuId().equals(innerSqrDTO.getSkuId())) && (innerSqrDTO.getpId()==null) ) {
						SkuDetailDTO pSkuDetailDTO = transformFromSQRToSDD(innerSqrDTO);
						//2.查找子属性
						List<SkuDetailDTO> subSkuDetailDTOList = new ArrayList<>();
						for(SkuQueryResultDTO subSqrDTO : skuQueryResultList) {
							//如果单品id相等并且父id相等
							if(subSqrDTO.getSkuId().equals(sqrDTO.getSkuId()) && pSkuDetailDTO.getId().equals(subSqrDTO.getpId())) {
								subSkuDetailDTOList.add(transformFromSQRToSDD(subSqrDTO));
							}
						}
						pSkuDetailDTO.setSubDetailList(subSkuDetailDTOList);//将找到的子属性加入父属性中
						skuDetailDTOList.add(pSkuDetailDTO);
						
					}
				}
				//3.将父属性存入集合
				skuDTO.setSkuDetailList(skuDetailDTOList);
				result.add(skuDTO);
				skuIdSet.add(sqrDTO.getSkuId());//把skuId加入set中
			}
		}
		
		return result;
	}
	
	/**
	 * 从SkuQueryResultDTO转换成SkuDetailDTO
	 * @param innerSqrDTO
	 * @return
	 */
	private SkuDetailDTO transformFromSQRToSDD(SkuQueryResultDTO innerSqrDTO) {
		SkuDetailDTO skuDetailDTO = new SkuDetailDTO();
		skuDetailDTO.setId(innerSqrDTO.getSkuDetailId());
		skuDetailDTO.setIndex(innerSqrDTO.getIndex());
		skuDetailDTO.setParamKey(innerSqrDTO.getParamKey());
		skuDetailDTO.setParamValue(innerSqrDTO.getParamValue());
		skuDetailDTO.setPid(innerSqrDTO.getpId());
		return skuDetailDTO;
	}
}
