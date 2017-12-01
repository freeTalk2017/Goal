package com.goal.wxpay;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goal.helper.WechatControllerHelper;
import com.goal.po.OAuth;
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
        out_trade_no = "201711127496748980290322";
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
        data.put("product_id", "12");
        data.put("openid", openid);
        
        try {
            result = wxpay.unifiedOrder(data);
            System.out.println(result);
            if(!result.containsKey("prepay_id")){
            	logger.error("get prepay id failed , the errer msg : {}",result.get("return_msg"));
            	return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return result;
	}
    
}
