package com.goal.helper;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.goal.dto.CmdPicDTO;
import com.goal.form.CmdDetailForm;
import com.goal.form.CmdParamsForm;
import com.goal.form.CmdPicForm;
import com.goal.service.CmdDetailService;

@Component("cmdDetailHelper")
public class CmdDetailControllerHelper extends GenericControllerHelper{

	@Resource
	CmdDetailService cmdDetailService;
	
	/**
	 * 通过商品id获取商品展示图片
	 * @return
	 */
	public List<CmdPicForm> getDisplayPicturesByCmdId(String cmdId,String showAs){
		CmdPicDTO cmdPicDTO = new CmdPicDTO();
		cmdPicDTO.setCmdId(cmdId);
		cmdPicDTO.setShowAs(showAs);
		List<CmdPicForm> list = cmdDetailService.getPicturesByCmdId(cmdPicDTO);
		list.parallelStream().forEach(dForm->dForm.setPicURL(combinePictureUrl(dForm.getPicURL())));
		return list;
	}

	/**
	 * 通过商品id获取商品详情图片
	 * @return
	 */
	public List<CmdPicForm> getDescriptonPicturesByCmdId(String cmdId,String showAs){
		CmdPicDTO cmdPicDTO = new CmdPicDTO();
		cmdPicDTO.setCmdId(cmdId);
		cmdPicDTO.setShowAs(showAs);
		List<CmdPicForm> list = cmdDetailService.getPicturesByCmdId(cmdPicDTO);
		list.parallelStream().forEach(dForm->dForm.setPicURL(combinePictureUrl(dForm.getPicURL())));
		return list;
	}
	
	/**
	 * 通过商品id获取商品基本信息
	 * @return
	 */
	public CmdDetailForm getCommodityByCmdId(String cmdId){
		return cmdDetailService.getCommodityByCmdId(cmdId);
	}
	
	/**
	 * 通过商品id获取商品参数
	 * @return
	 */
	public List<CmdParamsForm> getCmdParamsByCmdId(String cmdId){
		return cmdDetailService.getCmdParamsByCmdId(cmdId);
	}
}
