package com.goal.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/code")
	public @ResponseBody Object getCode(){
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
	}
	
	@RequestMapping("/check")
	public @ResponseBody Object callbackBase(@RequestParam(value = "code", required = false) String code, HttpServletResponse response) throws IOException{
		logger.debug("do callback base");
		
		Map<String, String> result = null;
		PrepayForm prepayForm = null;
		
		if (code == null || "".equals(code)) {
			logger.error("request code failed");
			response.sendRedirect("/trade/HTMLPage3.html");
			return null;
		}
		
		String openid = wechatControllerHelper.getOpenIdBySlientAuthy(code);
		if("".equals(openid)){
			try {
				response.sendRedirect("/trade/HTMLPage2.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		logger.debug("openid = {}",openid);
		
		if("".equals(openid)){
			logger.error("openid is null");
			response.sendRedirect("/trade/HTMLPage3.html");
			return null;
		}
		
		result = wechatControllerHelper.doUnifiedOrder(openid);
		
		if("".equals(result)){
			logger.error("unified order is null");
			return null;
		}
		
		prepayForm =wechatControllerHelper.generatePrepayForm(result);
		
		if("".equals(prepayForm)){
			logger.error("prepay form is null");
			return null;
		}
		
		try {
			StringBuilder url = new StringBuilder("/trade/HTMLPage3.html?")
					.append("appId=").append(prepayForm.getAppId())
					.append("&timeStamp=").append(prepayForm.getTimeStamp())
					.append("&nonceStr=").append(prepayForm.getNonceStr())
					.append("&package_pre=").append(prepayForm.getPackage_pre())
					.append("&signType=").append(prepayForm.getSignType())
					.append("&paySign=").append(prepayForm.getPaySign());
			response.sendRedirect(url.toString());
		} catch (IOException e) {
			logger.error("redirect : {}",e);
		}
//		ModelAndView modelAndView = new ModelAndView("wxpay");
//		modelAndView.addObject("appId",prepayForm.getAppId());
//		return modelAndView;
		return prepayForm;
	}
	
}
