package com.goal.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goal.dto.OrderDTO;
import com.goal.dto.ResponseOrderDTO;
import com.goal.helper.OrderControllerHelper;

@Controller
@RequestMapping("/orders")
public class OrderController {
	private static Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Resource
	private OrderControllerHelper orderHelper;
	
	@RequestMapping(value="/orderConfirmation",method=RequestMethod.POST)
	public @ResponseBody ResponseOrderDTO orderConfirm(@RequestBody OrderDTO dto) throws Exception {
		log.info("request orderConfirmation URL...");
		return orderHelper.submitOrder(dto);
	}
}
