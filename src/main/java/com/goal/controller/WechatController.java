package com.goal.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goal.form.PrepayForm;
import com.goal.helper.WechatControllerHelper;
import com.goal.util.RequestUtil;
import com.goal.util.WXRequestUtil;

@Controller
@RequestMapping("/trade")
public class WechatController extends AbstractController{

	public static Logger logger = LoggerFactory.getLogger(WechatController.class);
	
	@Resource
	WechatControllerHelper wechatControllerHelper;
	
//	@RequestMapping("/code")
//	public @ResponseBody Object getCode(){
//		logger.debug("do get request code");
//		final Boolean isCode = true;
//		RequestUtil requestUtil = new RequestUtil();
//		String url = WXRequestUtil.getSilentUrl();
//		if(url != null){
//			try {
//				requestUtil.doGetUrl(url,isCode);
//			} catch (Exception e) {
//				logger.error("do get request code error");
//			}
//		}else{
//			logger.debug("url is null !");
//		}
//		return null;
//	}
	
	@RequestMapping("/code")
	public @ResponseBody Object callbackBase(@RequestParam(value = "code", required = false) String code, HttpServletResponse response){
		if (code == null){
			logger.debug("do get request code");
			final Boolean isCode = true;
			RequestUtil requestUtil = new RequestUtil();
			String url = WXRequestUtil.getSilentUrl();
			if(url != null){
				try {
					requestUtil.doGetUrl(url,isCode);
				} catch (Exception e) {
					logger.error("do get request code error");
				}
			}else{
				logger.debug("url is null !");
			}
			return null;
		}else{
			logger.debug("do callback base");
			
			Map<String, String> result = null;
			PrepayForm prepayForm = null;
			
			String openid = wechatControllerHelper.getOpenIdBySlientAuthy(code);
			logger.debug("openid = {}",openid);
			
			if("".equals(openid)){
				logger.debug("openid is null");
				return null;
			}
			
			result = wechatControllerHelper.doUnifiedOrder(openid);
			
			if("".equals(result)){
				logger.debug("unified order is null");
				return null;
			}
			
			prepayForm =wechatControllerHelper.generatePrepayForm(result);
			
			if("".equals(prepayForm)){
				logger.debug("prepay form is null");
				return null;
			}
			
			return prepayForm;
		}
	}
	
}
