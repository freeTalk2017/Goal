package com.goal.controllerhelper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.goal.form.PrepayForm;
import com.goal.helper.WechatControllerHelper;
import com.goal.util.RequestUtil;
import com.goal.util.WXRequestUtil;
import com.goal.wxpay.WXPayConstants;
import com.goal.wxpay.WXPayUtil;
import com.goal.wxpay.WXPayConstants.SignType;

public class WechatControllerHelperTest {

	public WechatControllerHelper wechatControllerHelper = new WechatControllerHelper();
	
	@Test
	public void testGetOpenIdBySlientAuthy(){
		String code = "061d5WrP1vW2C31eyrrP1lAGrP1d5Wrm";
		
		System.out.println(wechatControllerHelper.getOpenIdBySlientAuthy(code));
	}
	
	@Test
	public void testDoUnifiedOrder() {
		String openid = "oCpKWwhDE1t1LmF-OjOlyRsQvz8Y";
		
		System.out.println(wechatControllerHelper.doUnifiedOrder(openid));
	}
	
	@Test
	public void testGeneratePrepayForm(){
		String openid = "oCpKWwhDE1t1LmF-OjOlyRsQvz8Y";
		Map<String, String> unified = wechatControllerHelper.doUnifiedOrder(openid);
		PrepayForm prepayForm = wechatControllerHelper.generatePrepayForm(unified);
		System.out.println(prepayForm.toString());
	}
	
	@Test
	public void testGetCode() throws ClientProtocolException, IOException{
		RequestUtil requestUtil = new RequestUtil();
		String url = WXRequestUtil.getSilentUrl();
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response;
		String result;
		if(url != null){
//			try {
//				JSONObject json = requestUtil.doGetUrl(url);
//				System.out.println(json);
//			} catch (Exception e) {
//				System.out.println("do get request code error :"+e);
//			}
			httpGet.setHeader("User-Agent","Mozilla/5.0 (Linux; U; Android 2.3.6; zh-cn; GT-S5660 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MicroMessenger/4.5.255");
			httpGet.setHeader("Referer", "https://mp.weixin.qq.com");
			response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity);
			System.out.println(result);
		}else{
			System.out.println("url is null !");
		}
	}
	
	@Test
	public void testEncode() throws UnsupportedEncodingException{
		String url = URLEncoder.encode("http://www.makeiteasy.xin/trade/HTMLPage3.html", "utf-8");
		System.out.println(url);
	}
	
	@Test
	public void testPaySign() throws Exception{
		Map<String, String> data = new HashMap<String, String>();
		data.put("appId", "wx2421b1c4370ec43b");
		data.put("nonceStr", "e61463f8efa94090b1f366cccfbbb444");
		data.put("package", "prepay_id=u802345jgfjsdfgsdg888");
		data.put("timeStamp", "1395712654");
		data.put("signType", SignType.MD5.toString());
		String paySign = WXPayUtil.generateSignature(data, WXPayConstants.SECRET, SignType.MD5);
		System.out.println(paySign);
	}
}
