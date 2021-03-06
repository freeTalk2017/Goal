package com.goal.wxpay;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goal.po.OAuth;
import com.goal.util.AmountUtils;
import com.goal.wxpay.WXPay;
import com.goal.wxpay.WXPayConfigImpl;

public class WXPayPerformance {

	public static Logger logger = LoggerFactory.getLogger(WXPayPerformance.class);

    private WXPay wxpay;
    private WXPayConfigImpl config;
    private String out_trade_no;
    private String total_fee;
    
    
	public WXPayPerformance() throws Exception {
		config = WXPayConfigImpl.getInstance();
        wxpay = new WXPay(config);
        total_fee = "1";
        int random = new java.util.Random().nextInt(900)+100;
        out_trade_no = "2017120374967489802903"+Integer.toString(random);
	}
    
	public Map<String, String> doUnifiedOrder(OAuth oAuth){
		
		Map<String, String> result = null;
		
		HashMap<String, String> data = new HashMap<String, String>();		
		data.put("body", "冲个玩玩");
		data.put("out_trade_no", out_trade_no);
        data.put("device_info", "WEB");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "59.110.240.8");
        data.put("notify_url", "http://www.makeiteasy.xin/wxpay/notify");
        data.put("trade_type", "JSAPI");
        data.put("product_id", "12");
        data.put("openid", oAuth.getOpenid());
        
        try {
            result = wxpay.unifiedOrder(data);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return result;
	}
	
	public Map<String, String> doUnifiedOrder(String openid){
		
		Map<String, String> result = null;
		
		HashMap<String, String> data = new HashMap<String, String>();		
		data.put("body", "冲个玩玩");
		data.put("out_trade_no", out_trade_no);
        data.put("device_info", "WEB");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "59.110.240.8");
        data.put("notify_url", "http://www.makeiteasy.xin/wxpay/notify");
        data.put("trade_type", "JSAPI");
        data.put("product_id", "24");
        data.put("openid", openid);
        
        try {
            result = wxpay.unifiedOrder(data);
            if(!result.containsKey("prepay_id")){
            	logger.error("get prepay id failed , the errer msg : {}",result.get("return_msg"));
            	return null;
            }
        } catch (Exception e) {
            logger.error("do unified order failed ,msg: {}",e);
        }
        
        try {
			result = putPrice2Result(result, data.get("total_fee"));
		} catch (Exception e) {
			logger.error("price format conversion failed :{}",e);
		}
        
		return result;
	}

	//将总价加入到result中，为了返回给页面显示金额
	public Map<String, String> putPrice2Result(Map<String, String> result, String price) throws Exception{
		result.put("price", AmountUtils.changeF2Y(price));
		return result;
	}
    
}
