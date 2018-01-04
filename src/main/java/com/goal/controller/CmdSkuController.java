package com.goal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goal.dto.SkuDTO;
import com.goal.helper.CmdSkuControllerHelper;
import com.goal.service.CmdSkuService;


@Controller
@RequestMapping("/cmdSku")
/**
 * 单品controller
 * @author lizhiwei
 *
 */
public class CmdSkuController extends AbstractController{
	private static final Logger LOG = LoggerFactory.getLogger(CmdSkuController.class);
	
	@Autowired
	private CmdSkuControllerHelper skuControllerHelper;
	
	@RequestMapping(value="/skuDetail/{cmdId}",method=RequestMethod.GET)
	public @ResponseBody List<SkuDTO> getSkuByCmdId(@PathVariable String cmdId) {
		LOG.debug("into the method getSkuByCmdId()");
		LOG.debug("Cmd Id:"+cmdId);
		SkuDTO dto = new SkuDTO();
		dto.setCmdId(cmdId);
		return skuControllerHelper.getSkuListByCmdId(dto);
	}
}
