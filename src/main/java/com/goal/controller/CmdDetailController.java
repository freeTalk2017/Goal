package com.goal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goal.form.CmdDetailForm;
import com.goal.helper.CmdDetailControllerHelper;

@Controller
@RequestMapping(value="/detail")
public class CmdDetailController extends AbstractController {

	private static final Log logger = LogFactory.getLog(CmdDetailController.class);
	
	@ResponseBody
	@RequestMapping(value="/{cmdId}",method=RequestMethod.GET)
	public Object cmdDetail(@PathVariable String cmdId) throws JsonProcessingException{
		ObjectMapper mapper= new ObjectMapper();
		CmdDetailForm cmdDetailForm = new CmdDetailForm();
		logger.info(mapper.writeValueAsString(cmdDetailForm));
		return new CmdDetailForm();
	}
	
	@ResponseBody
	@RequestMapping(value="/Detail",method=RequestMethod.GET)
	public Object cmdDetailJason(@RequestBody CmdDetailForm cmdDetailForm) throws JsonProcessingException{
		ObjectMapper mapper= new ObjectMapper();
		logger.info(mapper.writeValueAsString(cmdDetailForm));
		//cmdDetailForm
		return cmdDetailForm;
	}
	
	@ResponseBody
	@RequestMapping(value="/display/{cmdId}",method=RequestMethod.GET)
	public Object getDetailPictures(@PathVariable String cmdId){
		CmdDetailControllerHelper helper = new CmdDetailControllerHelper();
		String showAs = "p";
		return helper.getDisplayPicturesByCmdId(cmdId, showAs);
	}
	
	@ResponseBody
	@RequestMapping(value="/description/{cmdId}",method=RequestMethod.GET)
	public Object getDetailDescriprions(@PathVariable String cmdId){
		CmdDetailControllerHelper helper = new CmdDetailControllerHelper();
		String showAs="d";
		return helper.getDescriptonPicturesByCmdId(cmdId, showAs);
	}
	
	@ResponseBody
	@RequestMapping(value="/commodity/{cmdId}",method=RequestMethod.GET)
	public Object getCommodity(@PathVariable String cmdId){
		CmdDetailControllerHelper helper = new CmdDetailControllerHelper();
		return helper.getCommodityByCmdId(cmdId);
	}
	
	@ResponseBody
	@RequestMapping(value="/param/{cmdId}",method=RequestMethod.GET)
	public Object getCmdParam(@PathVariable String cmdId){
		CmdDetailControllerHelper helper = new CmdDetailControllerHelper();
		return helper.getCmdParamsByCmdId(cmdId);
		
	}
}