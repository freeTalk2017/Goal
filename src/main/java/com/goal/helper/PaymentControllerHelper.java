package com.goal.helper;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goal.dto.CodeDTO;
import com.goal.form.PrepayForm;
import com.goal.po.OAuth;
import com.goal.wxpay.WXPay;
import com.goal.wxpay.WXPayConfigImpl;
import com.goal.wxpay.WXPayPerformance;

import net.sf.json.JSONObject;

@Component("paymentHelper")
public class PaymentControllerHelper extends GenericControllerHelper{

	private static final Log logger = LogFactory.getLog(PaymentControllerHelper.class);
	
	private static final String RAW_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
	private static final String APPID = "wxa1378048216955b0";
	private static final String SECRET = "6ac0b7bfb762290e38034fd159d8d777";
	private static final String GRANT_TYPE = "authorization_code";

	
	
	/**
	 * 通过code得到openid
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public OAuth generateOpenid(CodeDTO codeDTO) throws ClientProtocolException, IOException{
		logger.debug("generate openid");
		String jsonStr = null;
		
		if("".equals(codeDTO.getCode()));
		if("".equals(codeDTO.getState()));
		
		
		StringBuffer realURL = new StringBuffer();
		realURL.append(RAW_URL).append("?appid=").append(APPID).append("&secret=").append(SECRET)
				.append("&code=").append(codeDTO.getCode()).append("&grant_type=").append(GRANT_TYPE);
		
		logger.debug("request url:" + realURL);
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		HttpGet request = new HttpGet(realURL.toString());
		
		CloseableHttpResponse response = httpclient.execute(request);
		
		try{
			System.out.println(response.getStatusLine());
			jsonStr = EntityUtils.toString(response.getEntity(),"UTF-8");
		}finally {
			response.close();
		}
		
		OAuth oAuth = jsonToObject(jsonStr);
		return oAuth;
	}
	
	/**
	 * json转换Object
	 * @return {@link OAuth}
	 */
	public OAuth jsonToObject(String json){
		JSONObject jsonObject = JSONObject.fromObject(json);
		jsonObject.getString("openid");
		if(!jsonObject.containsKey("errcode")){
			logger.debug("request success!!");
			return (OAuth)JSONObject.toBean(jsonObject,OAuth.class);
		}
		logger.debug("request failed!!");
		return null;
	}
	
	/**
	 * 统一下单
	 * @return 
	 */
	public Map<String, String> doUnifiedOrder(OAuth oAuth) throws Exception{
		
		logger.debug("do unified order");
		
		Map<String, String> unified = null;
		
		WXPayPerformance wxPay = new WXPayPerformance();
		
		unified = wxPay.doUnifiedOrder(oAuth);
		
		if (unified != null) {
			logger.debug("unified order process successful");
			return unified;
		}
		logger.debug("unified order process failed");
		return unified;
	}
	
	public PrepayForm processPrepay(Map<String,String> unified){
		logger.debug("process prepay");
		PrepayForm prepayForm = new PrepayForm();
		if("FAIL".equals(unified.get("return_code"))){
			return null;
		}
		
		long timeLong = System.currentTimeMillis();
		timeLong /= 1000.0;
		String timeStr = Long.toString(timeLong);
		
		prepayForm.setAppId(APPID);
		prepayForm.setNonceStr(unified.get("nonce_str"));
		prepayForm.setPackage_pre("prepay_id" + unified.get("prepay_id"));
		prepayForm.setPaySign(unified.get("sign"));
		prepayForm.setSignType("MD5");
		prepayForm.setTimeStamp(timeStr);
		
		logger.debug(prepayForm.toString());
		return prepayForm;
	}
}
