package com.goal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goal.form.SerialsForm;
import com.goal.helper.SerialsControllerHelper;

/**
 * 系列控制器
 * @author lizhiwei
 *
 */
@RequestMapping("/homepage/serials")
public class SerialsController extends AbstractController{
	@Autowired
	SerialsControllerHelper helper;
	
	/**
	 * 取得滑动控件的集合
	 * @return
	 */
	@RequestMapping(value="/sliders",method=RequestMethod.GET)
	public @ResponseBody List<SerialsForm> getSliderList(){
		
		return helper.getSliderListByParentId(helper.getSerialForm());
	}
}