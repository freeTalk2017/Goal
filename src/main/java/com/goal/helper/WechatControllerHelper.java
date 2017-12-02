package com.goal.helper;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.goal.form.PrepayForm;
import com.goal.util.RequestUtil;
import com.goal.wxpay.WXPayConstants;
import com.goal.wxpay.WXPayConstants.SignType;
import com.goal.wxpay.WXPayPerformance;
import com.goal.wxpay.WXPayUtil;

@Component("wechatControllerHelper")
public class WechatControllerHelper {

	public static Logger logger = LoggerFactory.getLogger(WechatControllerHelper.class);
	
	public String getOpenIdBySlientAuthy(String code){
		
		//String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxa1378048216955b0&secret=6ac0b7bfb762290e38034fd159d8d777&code=" + code + "&grant_type=authorization_code";
		if("".equals(code)||code == null){
			return null;
		}
		StringBuilder url = new StringBuilder();
		url.append("https://api.weixin.qq.com/sns/oauth2/access_token?")
			.append("appid=").append(WXPayConstants.APPID)
			.append("&secret=").append("6ac0b7bfb762290e38034fd159d8d4a6"/*WXPayConstants.SECRET*/)
			.append("&code=").append(code)
			.append("&grant_type=authorization_code");
		RequestUtil requestUtil = new RequestUtil();
		JSONObject jsonObject = null;
		try {
			jsonObject = requestUtil.doGetUrl(url.toString());
		} catch (Exception e) {
			logger.error("request openid errer");
		}
		
		return jsonObject.getString("openid");
	}
	
	public Map<String, String> doUnifiedOrder(String openid){
		logger.debug("do unified order");
		
		Map<String, String> unified = null;
		WXPayPerformance wxPay = null;
		
		try {
			 wxPay = new WXPayPerformance();
		} catch (Exception e) {
			logger.debug("initialize WXPayPerformance failed :{}",e);
		}
		
		unified = wxPay.doUnifiedOrder(openid);
		
		if( unified != null){
			logger.debug("unified order process successful");
			return unified;
		}
		
		logger.debug("unified order process failed");
		return unified;
	}
	
	public PrepayForm generatePrepayForm(Map<String, String> unified){
		logger.debug("do generate prepay form");
		Map<String, String> data = new HashMap<String, String>();
		PrepayForm prepayForm = new PrepayForm();
		String paySign = null;
		long timeLong = System.currentTimeMillis();
		timeLong /= 1000.0;
		String timeStr = Long.toString(timeLong);
		
		if("FAIL".equals(unified.get("return_code"))){
			return null;
		}
		
		data.put("appId", WXPayConstants.APPID);
		data.put("nonceStr", unified.get("nonce_str"));
		data.put("package", "prepay_id=" + unified.get("prepay_id"));
		data.put("timeStamp", timeStr);
		data.put("signType", SignType.HMACSHA256.toString());
				
		try {
//			paySign = WXPayUtil.generateSignature(data, WXPayConstants.SECRET, SignType.MD5);
			paySign = WXPayUtil.generateSignature(data, WXPayConstants.SECRET, SignType.HMACSHA256);
//			String str = "appId="+WXPayConstants.APPID+"&nonceStr="+unified.get("nonce_str")+"&package=prepay_id="+unified.get("prepay_id")+"&timeStamp="+timeStr;
//			paySign = WXPayUtil.HMACSHA256(str, WXPayConstants.SECRET);
		} catch (Exception e) {
			logger.error("generate prepay form sign failed :{}",e);
		}
		
		prepayForm.setAppId(WXPayConstants.APPID);
		prepayForm.setNonceStr(unified.get("nonce_str"));
		prepayForm.setPackage_pre("prepay_id=" + unified.get("prepay_id"));
		prepayForm.setPaySign(paySign);
//		prepayForm.setSignType(SignType.MD5);
		prepayForm.setSignType(SignType.HMACSHA256);
		prepayForm.setTimeStamp(timeStr);
		
		logger.debug(prepayForm.toString());
		return prepayForm;
	}
}
