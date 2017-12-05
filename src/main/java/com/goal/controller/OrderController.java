package com.goal.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goal.dto.OrderDTO;
import com.goal.helper.OrderControllerHelper;

@Controller
@RequestMapping("/orders")
public class OrderController {
	@Resource
	private OrderControllerHelper orderHelper;
	
	@RequestMapping(value="/orderConfirmation",method=RequestMethod.POST)
	public @ResponseBody OrderDTO orderConfirm(@ModelAttribute("form") OrderDTO dto) {
		return orderHelper.submitOrder(dto);
	}
}
