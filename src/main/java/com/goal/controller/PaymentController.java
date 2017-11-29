package com.goal.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.ClientProtocolException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goal.dto.CodeDTO;
import com.goal.form.PrepayForm;
import com.goal.helper.PaymentControllerHelper;
import com.goal.po.OAuth;


@Controller
@RequestMapping(value="/trade")
public class PaymentController extends AbstractController{

	private static final Log logger = LogFactory.getLog(PaymentController.class);
	
	@Resource
	PaymentControllerHelper helper;
	
	/**
	 * 处理支付预支付流程
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/wxpay",method=RequestMethod.GET)
	public Object processPayment(@RequestParam("code") String code,@RequestParam("state") String state){
		PrepayForm prepayForm = null;
		Map<String, String> result = null;
		
		CodeDTO dto = new CodeDTO();
		dto.setCode(code);
		dto.setState(state);
		
		OAuth oAuth = null;
		
		try {
			oAuth = helper.generateOpenid(dto);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("get oauth failed!");
		}
		
		if (oAuth == null) {
			logger.debug(dto.getCode() + "could not get the openid !!");
			return "failed";
		}
		
		try {
			logger.debug("prepare for unified order");
			result = helper.doUnifiedOrder(oAuth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("prepare for process prepay");
		prepayForm = helper.processPrepay(result);
		if(prepayForm ==null){
			logger.debug("process prepay failed");
			return null;
		}
		logger.debug("process prepay successfully");
		return prepayForm;
	}
}
